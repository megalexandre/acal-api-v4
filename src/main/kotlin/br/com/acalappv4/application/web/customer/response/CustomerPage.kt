package br.com.acalappv4.application.web.customer.response

import br.com.acalappv4.common.enums.PersonType

class CustomerPage (
    val id: String,
    val name: String,
    val documentNumber: String,
    val personType: PersonType,
    val active: Boolean
)
