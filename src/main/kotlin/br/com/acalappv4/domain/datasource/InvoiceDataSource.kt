package br.com.acalappv4.domain.datasource

import br.com.acalappv4.domain.dto.list.InvoiceFilter
import br.com.acalappv4.domain.entity.Invoice

interface InvoiceDataSource {

    fun findAll(input: InvoiceFilter): List<Invoice>

    fun exists(input: InvoiceFilter): Boolean
}