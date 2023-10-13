package br.com.acalappv4.resource.query.def

import br.com.acalappv4.domain.dto.page.PageFilter
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction.ASC

open class DefQuery {

    private val defaultSort = Sort.by( ASC,"id")

    fun pageRequest(page: PageFilter): PageRequest =
        PageRequest.of(
            page.page?.number ?: 0,
            page.page?.size ?: 10,

            when(val sort = page.sort){
                null -> defaultSort
                else -> Sort.by( sort.direction?: ASC, sort.field ?: "name")
            }
        )

}


