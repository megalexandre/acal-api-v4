package br.com.acalappv4.application.web.customer.response

import br.com.acalappv4.domain.entity.Customer

data class CustomerCreateResponse (
    val id: String,
){
    constructor(customer: Customer) : this(
        id = customer.id
    )
}

