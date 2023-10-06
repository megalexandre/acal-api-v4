package br.com.acalappv4.application.web.link.request

import br.com.acalappv4.domain.dto.Page
import br.com.acalappv4.domain.dto.PageFilterLink
import br.com.acalappv4.domain.dto.Sort

class PageFilterLinkRequest(
    val id: String?,

    val active: Boolean? = null,
    val createdBy: String ? = null,

    val page: Page?,
    val sort: Sort?,
){

    fun toEntity(): PageFilterLink = PageFilterLink(
        id = id,
        page = page,
        active = active,
        createdBy = createdBy,
        sort = sort,
    )
}