package br.com.acalappv4.application.web.customer.request

import br.com.acalappv4.common.enums.PersonType
import br.com.acalappv4.domain.dto.Page
import br.com.acalappv4.domain.dto.Sort

class CustomerPageRequest(
    val id: String?,
    val name: String?,
    val documentNumber: String?,
    val personType: PersonType?,
    val active: Boolean?,
    val page: Page?,
    val sort: Sort?,
)

