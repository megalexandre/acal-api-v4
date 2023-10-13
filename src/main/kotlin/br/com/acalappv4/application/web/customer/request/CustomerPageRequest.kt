package br.com.acalappv4.application.web.customer.request

import br.com.acalappv4.common.enums.PersonType
import br.com.acalappv4.domain.dto.page.Page
import br.com.acalappv4.domain.dto.page.PageFilterCustomer
import br.com.acalappv4.domain.dto.page.Sort

class CustomerPageRequest(
    val id: String?,
    val name: String?,
    val documentNumber: String?,
    val personType: PersonType?,
    val active: Boolean?,
    val page: Page?,
    val sort: Sort?,
){
    fun toEntity(): PageFilterCustomer =
        PageFilterCustomer(
            id = id,
            name =  name,
            documentNumber = documentNumber,
            personType = personType,
            active = active,
            page = page,
            sort = sort
        )
}

