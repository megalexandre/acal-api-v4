package br.com.acalappv4.resource.datasourceImpl

import br.com.acalappv4.domain.dto.page.PageFilterCustomer
import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.DocumentNumber
import br.com.acalappv4.domain.datasource.CustomerDataSource
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
class CustomerDataSourceImpl(
    private val customerRepository: CustomerRepository,
    private val mongoTemplate: MongoTemplate,
): CustomerDataSource {

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

    override fun paginate(pageFilterCustomer: PageFilterCustomer): Page<Customer> {
        val customerQuery = CustomerQuery(pageFilterCustomer)

        val pageable = customerQuery.pageRequest()
        val query = customerQuery.query().with(pageable)
        val countTotal = customerQuery.query()

        val list = mongoTemplate.find(query, CustomerDocument::class.java)
        val count: Long = mongoTemplate.count(countTotal, CustomerDocument::class.java)
        val page = PageImpl(list, pageable, count)

        return page.toCustomer()
    }
}