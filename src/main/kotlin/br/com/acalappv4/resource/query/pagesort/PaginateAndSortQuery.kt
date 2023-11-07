package br.com.acalappv4.resource.query.pagesort

import br.com.acalappv4.domain.dto.list.DefaultFilter
import br.com.acalappv4.domain.dto.page.PageFilter
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction.ASC
import org.springframework.data.mongodb.core.query.Query

abstract class PaginateAndSortQuery<T: DefaultFilter> {

    private val id = "id"
    private val defaultSort = Sort.by(ASC,id)
    open fun pageRequest(page: PageFilter): PageRequest =
        PageRequest.of(
            page.page?.number ?: 0,
            page.page?.size ?: 10,

            when(val sort = page.sort){
                null -> defaultSort
                else -> Sort.by( sort.direction?: ASC, sort.field ?: id)
            }
        )

    abstract fun query(filter: T?): Query
}



