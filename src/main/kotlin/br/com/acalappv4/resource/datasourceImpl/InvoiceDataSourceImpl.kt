package br.com.acalappv4.resource.datasourceImpl

import br.com.acalappv4.domain.datasource.InvoiceDataSource
import br.com.acalappv4.domain.dto.list.InvoiceFilter
import br.com.acalappv4.domain.entity.Invoice
import br.com.acalappv4.resource.adapter.toInvoice
import br.com.acalappv4.resource.document.InvoiceDocument
import br.com.acalappv4.resource.query.InvoiceQuery
import br.com.acalappv4.resource.repository.LinkRepository
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class InvoiceDataSourceImpl(
    private val repository: LinkRepository,
    private val mongoTemplate: MongoTemplate,
): InvoiceDataSource {

    override fun findAll(input: InvoiceFilter): List<Invoice> =
        mongoTemplate.find(InvoiceQuery().query(input), InvoiceDocument::class.java).toInvoice()

    override fun exists(input: InvoiceFilter): Boolean =
        mongoTemplate.find(InvoiceQuery().query(input), InvoiceDocument::class.java).isNotEmpty()

}