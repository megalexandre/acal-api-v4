package br.com.acalappv4.domain.datasource

import br.com.acalappv4.domain.dto.list.InvoiceFilter
import br.com.acalappv4.domain.dto.page.InvoicePageFilter
import br.com.acalappv4.domain.entity.Invoice
import org.springframework.data.domain.Page

interface InvoiceDataSource {

    fun findAll(input: InvoiceFilter): List<Invoice>

    fun exists(input: InvoiceFilter): Boolean

    fun save(invoice: Invoice): Invoice

    fun paginate(invoicePageFilter: InvoicePageFilter): Page<Invoice>
}