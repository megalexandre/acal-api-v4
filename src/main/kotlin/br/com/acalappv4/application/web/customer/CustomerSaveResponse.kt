package br.com.acalappv4.application.web.customer

import br.com.acalappv4.domain.entity.Customer

data class CustomerSaveResponse (
    val id: String,
)

fun Customer.toCustomerSaveResponse() = CustomerSaveResponse(
    id = id,
)
