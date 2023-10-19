package br.com.acalappv4.resource.datasourceImpl

import br.com.acalappv4.domain.datasource.InvoiceDataSource
import br.com.acalappv4.domain.dto.list.InvoiceFilter
import br.com.acalappv4.domain.dto.page.InvoicePageFilter
import br.com.acalappv4.domain.entity.Invoice
import br.com.acalappv4.resource.adapter.InvoiceAdapter.Companion.toDocument
import br.com.acalappv4.resource.adapter.InvoiceAdapter.Companion.toEntity
import br.com.acalappv4.resource.adapter.toInvoice
import br.com.acalappv4.resource.document.InvoiceDocument
import br.com.acalappv4.resource.query.InvoiceQuery
import br.com.acalappv4.resource.repository.InvoiceRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class InvoiceDataSourceImpl(
    private val repository: InvoiceRepository,
    private val mongoTemplate: MongoTemplate,
): InvoiceDataSource {

    override fun findAll(input: InvoiceFilter): List<Invoice> =
        mongoTemplate.find(InvoiceQuery().query(input), InvoiceDocument::class.java).toInvoice()

    override fun exists(input: InvoiceFilter): Boolean =
        mongoTemplate.find(InvoiceQuery().query(input), InvoiceDocument::class.java).isNotEmpty()

    override fun save(invoice: Invoice): Invoice = toEntity(repository.save(toDocument(invoice) ))

    override fun paginate(invoicePageFilter: InvoicePageFilter): Page<Invoice> {

        val invoiceQuery = InvoiceQuery()

        val pageable = invoiceQuery.pageRequest(invoicePageFilter)
        val query = invoiceQuery.query(invoicePageFilter.filter).with(pageable)
        val countTotal = invoiceQuery.query(invoicePageFilter.filter)

        val list = mongoTemplate.find(query, InvoiceDocument::class.java)
        val count: Long = mongoTemplate.count(countTotal, InvoiceDocument::class.java)
        val page = PageImpl(list, pageable, count)

        return page.toInvoice()
    }

}