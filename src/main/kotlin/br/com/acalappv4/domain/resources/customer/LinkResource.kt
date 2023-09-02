package br.com.acalappv4.domain.resources.customer

import br.com.acalappv4.domain.entity.Customer

fun interface LinkResource {

    fun existsByCustomer(customer: Customer): Boolean

}