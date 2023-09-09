package br.com.acalappv4.resource.resourceImpl

import br.com.acalappv4.domain.dto.CustomerPageFilter
import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.DocumentNumber
import br.com.acalappv4.domain.resources.CustomerResource
import br.com.acalappv4.resource.adapter.CustomerAdapter.Companion.toDocument
import br.com.acalappv4.resource.adapter.CustomerAdapter.Companion.toEntity
import br.com.acalappv4.resource.adapter.toCustomer
import br.com.acalappv4.resource.document.CustomerDocument
import br.com.acalappv4.resource.query.CustomerQuery
import br.com.acalappv4.resource.repository.CustomerRepository
import kotlin.jvm.optionals.getOrNull
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository


@Repository
class CustomerResourceImpl(
    private val customerRepository: CustomerRepository,
    private val mongoTemplate: MongoTemplate,
): CustomerResource {

    override fun save(customer: Customer): Customer = toEntity(customerRepository.save(toDocument(customer)))

    override fun delete(id: String) = customerRepository.deleteById(id)

    override fun existsByDocument(documentNumber: DocumentNumber): Boolean =
        customerRepository.existsByDocumentNumberNumber(documentNumber.number)

    override fun findById(id: String): Customer? =
        customerRepository.findById(id)
            .map { toEntity(it) }
            .getOrNull()

    override fun findByDocument(documentNumber: DocumentNumber): Customer? =
        customerRepository.findByDocumentNumberNumber(documentNumber.number)
            .map { toEntity(it) }
            .getOrNull()

    override fun paginate(customerPageFilter: CustomerPageFilter): Page<Customer> {
        val customerQuery = CustomerQuery(customerPageFilter)

        val pageable = customerQuery.pageRequest()
        val query = customerQuery.query().with(pageable)

        val list = mongoTemplate.find(query, CustomerDocument::class.java)
        val count: Long = mongoTemplate.count(query, CustomerDocument::class.java)
        val page = PageImpl(list, pageable, count)

        return page.toCustomer()
    }
}