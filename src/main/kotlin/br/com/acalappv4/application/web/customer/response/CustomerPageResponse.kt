package br.com.acalappv4.application.web.customer.response

import br.com.acalappv4.domain.entity.Customer

class CustomerPageResponse (
    val id: String,
    val name: String,
    val documentNumber: String,
){
    constructor(customer: Customer) : this(
        id = customer.id,
        name = customer.name,
        documentNumber = customer.documentNumber.number
    )
}

