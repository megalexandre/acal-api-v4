package br.com.acalappv4.resource.query

import br.com.acalappv4.domain.dto.PageFilterLink
import br.com.acalappv4.util.normalize
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction.ASC
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class LinkQuery(private val linkFilter: PageFilterLink) {

    private val defaultSort = Sort.by( ASC,"id")

    fun pageRequest(): PageRequest =
        PageRequest.of(
            linkFilter.page?.number ?: 0,
            linkFilter.page?.size ?: 10,

            when(val sort = linkFilter.sort){
                null -> defaultSort
                else -> Sort.by( sort.direction?: ASC, sort.field ?: "name")
            }
        )

    fun query(): Query = Query().apply {
        with(linkFilter){
            if (!id.isNullOrEmpty()) {
                addCriteria(Criteria.where("id").`is`(id))
            }

            if (active != null) {
                addCriteria(Criteria.where("active").`is`(active))
            }
        }
    }


}

