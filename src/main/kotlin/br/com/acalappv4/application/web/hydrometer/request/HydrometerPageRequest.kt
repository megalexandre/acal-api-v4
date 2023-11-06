package br.com.acalappv4.application.web.hydrometer.request

import br.com.acalappv4.domain.dto.list.HydrometerFilter
import br.com.acalappv4.domain.dto.page.HydrometerPageFilter
import br.com.acalappv4.domain.dto.page.Page
import br.com.acalappv4.domain.dto.page.Sort

class HydrometerPageRequest(
    val id: String?,
    val page: Page?,
    val sort: Sort?,
){
    fun toEntity(): HydrometerPageFilter =
        HydrometerPageFilter(
            filter = HydrometerFilter(
                id = id,
            ),
            page = page,
            sort = sort
        )
}

