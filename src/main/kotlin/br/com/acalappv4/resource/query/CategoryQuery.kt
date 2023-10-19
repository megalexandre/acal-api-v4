package br.com.acalappv4.resource.query


import br.com.acalappv4.domain.dto.list.CategoryFilter
import br.com.acalappv4.resource.query.pagesort.PaginateAndSortQuery
import br.com.acalappv4.util.normalize
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class CategoryQuery: PaginateAndSortQuery<CategoryFilter>() {

    override fun query(filter: CategoryFilter?): Query = Query().apply {
        if (filter != null) {
            with(filter) {

                if (!id.isNullOrEmpty()) {
                    addCriteria(Criteria.where("id").`is`(id))
                }

                if (!name.isNullOrEmpty()) {
                    addCriteria(Criteria.where("nameNormalized").regex(name.normalize()))
                }

                if (waterValue != null) {
                    addCriteria(Criteria.where("waterValue").`is`(waterValue))
                }
                if (totalValue != null) {
                    addCriteria(Criteria.where("totalValue").`is`(totalValue))
                }

                if (categoryValue != null) {
                    addCriteria(Criteria.where("categoryValue").`is`(categoryValue))
                }

                if (categoryType != null) {
                    addCriteria(Criteria.where("type").`is`(categoryType))
                }

            }
        }
    }
}

