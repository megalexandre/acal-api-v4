package br.com.acalappv4.resource.query


import br.com.acalappv4.domain.dto.CategoryPageFilter
import br.com.acalappv4.util.normalize
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction.ASC
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class CategoryQuery(private val categoryFilter: CategoryPageFilter) {

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
                addCriteria(Criteria.where("nameNormalized").regex("^${name.normalize()}"))
            }

            if (value != null)  {
                addCriteria(Criteria.where("value").`is`(value))
            }

            if (categoryType != null) {
                addCriteria(Criteria.where("type").`is`(categoryType))
            }

        }
    }

}

