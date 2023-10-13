package br.com.acalappv4.resource.query


import br.com.acalappv4.domain.dto.page.PageFilterCategory
import br.com.acalappv4.util.normalize
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction.ASC
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class CategoryQuery(private val categoryFilter: PageFilterCategory) {

    private val defaultSort = Sort.by( ASC,"id")

    fun pageRequest(): PageRequest =
        PageRequest.of(
            categoryFilter.page?.number ?: 0,
            categoryFilter.page?.size ?: 10,

            when(val sort = categoryFilter.sort){
                null -> defaultSort
                else -> Sort.by( sort.direction?: ASC, sort.field ?: "id")
            }
        )

    fun query(): Query = Query().apply {
        with(categoryFilter){

            if (!id.isNullOrEmpty()) {
                addCriteria(Criteria.where("id").`is`(id))
            }

            if (!name.isNullOrEmpty()) {
                addCriteria(Criteria.where("nameNormalized").regex(name.normalize()))
            }

            if (waterValue != null)  {
                addCriteria(Criteria.where("waterValue").`is`(waterValue))
            }
            if (totalValue != null)  {
                addCriteria(Criteria.where("totalValue").`is`(totalValue))
            }

            if (categoryValue != null)  {
                addCriteria(Criteria.where("categoryValue").`is`(categoryValue))
            }

            if (categoryType != null) {
                addCriteria(Criteria.where("type").`is`(categoryType))
            }

        }
    }

}

