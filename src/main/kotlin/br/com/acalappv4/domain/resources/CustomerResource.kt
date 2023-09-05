package br.com.acalappv4.domain.resources

import br.com.acalappv4.domain.dto.CustomerPageFilter
import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.DocumentNumber
import org.springframework.data.domain.Page

interface CustomerResource {

    fun save(customer: Customer): Customer

    fun existsByDocument(documentNumber: DocumentNumber): Boolean

    fun findById(id: String): Customer?

    fun delete(id: String)

    fun findByDocument(documentNumber: DocumentNumber): Customer?

    fun paginate(customerPageFilter: CustomerPageFilter): Page<Customer>
}