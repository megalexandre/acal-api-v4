package br.com.acalappv4.application.web.link.request

import br.com.acalappv4.domain.dto.list.LinkFilter
import br.com.acalappv4.domain.dto.page.Page
import br.com.acalappv4.domain.dto.page.PageFilterLink
import br.com.acalappv4.domain.dto.page.Sort

class PageFilterLinkRequest(
    val id: String?,

    val active: Boolean? = null,
    val createdBy: String ? = null,

    val page: Page?,
    val sort: Sort?,
){

    fun toEntity(): PageFilterLink = PageFilterLink(
        linkFilter = LinkFilter(
            id = id,
            active = active,
            createdBy = createdBy
        ),
        page = page,
        sort = sort,
    )
}