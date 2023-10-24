package br.com.acalappv4.application.web.area.request

import br.com.acalappv4.domain.dto.list.AreaFilter
import br.com.acalappv4.domain.dto.page.Page
import br.com.acalappv4.domain.dto.page.AreaPageFilter
import br.com.acalappv4.domain.dto.page.Sort

class AreaPageFilterRequest(
    val id: String?,
    val name: String?,
    val page: Page?,
    val sort: Sort?,
){

    fun toEntity(): AreaPageFilter = AreaPageFilter(
        filter = AreaFilter(
            id = id,
            name = name,
        ),
        page = page,
        sort = sort,
    )

}