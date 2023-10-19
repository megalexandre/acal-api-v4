package br.com.acalappv4.application.web.invoice.response

import br.com.acalappv4.domain.entity.Invoice

data class CreateInvoiceResponse (
    val id: String,
){
    constructor(invoice: Invoice) : this(
        id = invoice.id
    )
}

