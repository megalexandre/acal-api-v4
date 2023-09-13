package br.com.acalappv4.domain.dto

import br.com.acalappv4.common.enums.PersonType

class PageFilterCustomer(
    val id: String?,
    val name: String?,
    val documentNumber: String?,
    val personType: PersonType?,
    val active: Boolean?,

    val page: Page?,
    val sort: Sort?,
)