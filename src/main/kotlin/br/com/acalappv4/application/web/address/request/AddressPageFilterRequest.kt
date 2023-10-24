package br.com.acalappv4.application.web.address.request

import br.com.acalappv4.domain.dto.list.AddressFilter
import br.com.acalappv4.domain.dto.page.AddressPageFilter
import br.com.acalappv4.domain.dto.page.Page
import br.com.acalappv4.domain.dto.page.Sort
import br.com.acalappv4.domain.entity.Area

class AddressPageFilterRequest(
    val id: String?,
    val number: String? = null,
    val area: Area? = null,
    val letter: String? = null,
    val hasHydrometer: Boolean?  = null,
    val page: Page?,
    val sort: Sort?,
){

    fun toEntity(): AddressPageFilter = AddressPageFilter(
        filter = AddressFilter(
            id = id,
            number = number,
            letter = letter,
            hasHydrometer = hasHydrometer,
            area = area,
        ),
        page = page,
        sort = sort,
    )

}