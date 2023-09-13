package br.com.acalappv4.application.web.address.request

import br.com.acalappv4.domain.dto.Page
import br.com.acalappv4.domain.dto.PageFilterAddress
import br.com.acalappv4.domain.dto.Sort
import br.com.acalappv4.domain.entity.Area

class PageFilterAddressRequest(
    val id: String?,
    val number: String? = null,
    val area: Area? = null,
    val letter: String? = null,
    val hasHydrometer: Boolean?  = null,
    val page: Page?,
    val sort: Sort?,
){

    fun toEntity(): PageFilterAddress = PageFilterAddress(
        id = id,
        number = number,
        letter = letter,
        hasHydrometer = hasHydrometer,
        area = area,
        page = page,
        sort = sort,
    )

}