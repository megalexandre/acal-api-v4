package br.com.acalappv4.resource.datasourceImpl

import br.com.acalappv4.domain.datasource.CustomerDataSource
import br.com.acalappv4.domain.dto.page.CustomerPageFilter
import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.DocumentNumber
import br.com.acalappv4.resource.adapter.CustomerAdapter.Companion.toDocument
import br.com.acalappv4.resource.adapter.CustomerAdapter.Companion.toEntity
import br.com.acalappv4.resource.adapter.toCustomer
import br.com.acalappv4.resource.document.CustomerDocument
import br.com.acalappv4.resource.event.Event.CUSTOMER_UPDATED
import br.com.acalappv4.resource.event.UpdatedDocumentEvent
import br.com.acalappv4.resource.query.CustomerQuery
import br.com.acalappv4.resource.repository.CustomerRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull


@Repository
class CustomerDataSourceImpl(
    private val repository: CustomerRepository,
    private val mongoTemplate: MongoTemplate,
    private val publisher: ApplicationEventPublisher,
): CustomerDataSource {

    @Transactional
    override fun save(customer: Customer): Customer = toEntity(repository.save(toDocument(customer)))

    @Transactional
    override fun update(customer: Customer): Customer =
        toEntity(repository.save(toDocument(customer)).also {
            publisher.publishEvent(UpdatedDocumentEvent(CUSTOMER_UPDATED.name, it))
        })

    override fun delete(id: String) = repository.deleteById(id)

    override fun existsByDocument(documentNumber: DocumentNumber): Boolean =
        repository.existsByDocumentNumberNumber(documentNumber.number)

    override fun findById(id: String): Customer? =
        repository.findById(id)
            .map { toEntity(it) }
            .getOrNull()

    override fun findByDocument(documentNumber: DocumentNumber): Customer? =
        repository.findByDocumentNumberNumber(documentNumber.number)
            .map { toEntity(it) }
            .getOrNull()

    override fun paginate(customerPageFilter: CustomerPageFilter): Page<Customer> {
        val customerQuery = CustomerQuery()

        val pageable = customerQuery.pageRequest(customerPageFilter)
        val query = customerQuery.query(customerPageFilter.filter).with(pageable)
        val countTotal = customerQuery.query(customerPageFilter.filter)

        val list = mongoTemplate.find(query, CustomerDocument::class.java)
        val count: Long = mongoTemplate.count(countTotal, CustomerDocument::class.java)
        val page = PageImpl(list, pageable, count)

        return page.toCustomer()
    }
}