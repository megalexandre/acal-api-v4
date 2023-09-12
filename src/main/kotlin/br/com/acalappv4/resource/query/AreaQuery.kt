package br.com.acalappv4.resource.query


import br.com.acalappv4.domain.dto.PageFilterArea
import br.com.acalappv4.util.normalize
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction.ASC
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class AreaQuery(private val areaFilter: PageFilterArea) {

    private val defaultSort = Sort.by( ASC,"id")

    fun pageRequest(): PageRequest =
        PageRequest.of(
            areaFilter.page?.number ?: 0,
            areaFilter.page?.size ?: 10,

            when(val sort = areaFilter.sort){
                null -> defaultSort
                else -> Sort.by( sort.direction?: ASC, sort.field ?: "id")
            }
        )

    fun query(): Query = Query().apply {
        with(areaFilter){

            if (!id.isNullOrEmpty()) {
                addCriteria(Criteria.where("id").`is`(id))
            }

            if (!name.isNullOrEmpty()) {
                addCriteria(Criteria.where("nameNormalized").regex("^${name.normalize()}"))
            }
        }
    }

}

