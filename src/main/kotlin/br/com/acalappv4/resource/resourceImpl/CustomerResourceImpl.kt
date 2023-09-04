package br.com.acalappv4.resource.resourceImpl

import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.DocumentNumber
import br.com.acalappv4.domain.resources.CustomerResource
import br.com.acalappv4.resource.adapter.toCustomer
import br.com.acalappv4.resource.adapter.toCustomerItem
import br.com.acalappv4.resource.repository.CustomerRepository
import org.springframework.stereotype.Repository

@Repository
class CustomerResourceImpl(
    private val customerRepository: CustomerRepository
    ): CustomerResource {

    override fun save(customer: Customer): Customer =
        customerRepository.save(customer.toCustomerItem()).toCustomer()

    override fun delete(id: String): Boolean = true

    override fun existsByDocument(documentNumber: DocumentNumber): Boolean =
        customerRepository.existsCustomerByDocumentNumber(documentNumber)

    override fun findById(id: String): Customer? = null

    override fun findByDocument(documentNumber: DocumentNumber): Customer? = null

}