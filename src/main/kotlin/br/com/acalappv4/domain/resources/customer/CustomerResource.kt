package br.com.acalappv4.domain.resources.customer

import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.Document

interface CustomerResource {

    fun save(customer: Customer): Customer

    fun delete(id: String): Boolean

    fun existsByDocument(document: Document): Boolean

    fun findById(id: String): Customer?

    fun findByDocument(document: Document): Customer?

}