package br.com.acalappv4.application.web.hydrometer.request

import br.com.acalappv4.domain.dto.list.AreaFilter
import br.com.acalappv4.domain.dto.list.HydrometerFilter
import br.com.acalappv4.domain.dto.page.HydrometerPageFilter
import br.com.acalappv4.domain.dto.page.Page
import br.com.acalappv4.domain.dto.page.Sort
import br.com.acalappv4.domain.entity.Reference

class HydrometerPageRequest(
    val id: String?,
    val page: Page?,
    val sort: Sort?,
    val area: AreaFilter?,
    val reference: Reference?,

){
    fun toEntity(): HydrometerPageFilter =
        HydrometerPageFilter(
            filter = HydrometerFilter(
                id = id,
                area = area,
                reference = reference,
            ),
            page = page,
            sort = sort
        )
}

