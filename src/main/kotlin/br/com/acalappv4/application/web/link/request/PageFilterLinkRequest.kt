package br.com.acalappv4.application.web.link.request

import br.com.acalappv4.domain.dto.list.LinkFilter
import br.com.acalappv4.domain.dto.page.Page
import br.com.acalappv4.domain.dto.page.LinkPageFilter
import br.com.acalappv4.domain.dto.page.Sort

class PageFilterLinkRequest(
    val id: String? = null,

    val active: Boolean? = null,
    val createdBy: String ? = null,

    val page: Page?,
    val sort: Sort?,
){

    fun toEntity(): LinkPageFilter = LinkPageFilter(
        linkFilter = LinkFilter(
            id = id,
            active = active,
            createdBy = createdBy
        ),
        page = page,
        sort = sort,
    )
}