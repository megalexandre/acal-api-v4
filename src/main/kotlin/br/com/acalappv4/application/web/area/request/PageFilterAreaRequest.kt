package br.com.acalappv4.application.web.area.request

import br.com.acalappv4.domain.dto.Page
import br.com.acalappv4.domain.dto.PageFilterArea
import br.com.acalappv4.domain.dto.Sort

class PageFilterAreaRequest(
    val id: String?,
    val name: String?,
    val page: Page?,
    val sort: Sort?,
){

    fun toEntity(): PageFilterArea = PageFilterArea(
        id = id,
        name = name,
        page = page,
        sort = sort,
    )

}