package br.com.acalappv4.application.web.invoice.response

import br.com.acalappv4.domain.entity.Invoice
import br.com.acalappv4.domain.entity.InvoiceDetail
import br.com.acalappv4.domain.entity.LinkDetail
import br.com.acalappv4.domain.entity.Reference
import org.springframework.data.domain.Page
import java.time.LocalDateTime

class InvoicePageResponse (
    val id: String,
    val reference: Reference,
    val emission: LocalDateTime,
    val dueDate: LocalDateTime,
    val linkDetail: LinkDetail,
    val invoiceDetails: List<InvoiceDetail>
){
    constructor(invoice: Invoice) : this(
        id = invoice.id,
        reference = invoice.reference,
        emission = invoice.emission,
        dueDate = invoice.dueDate,
        linkDetail = invoice.linkDetail,
        invoiceDetails = invoice.invoiceDetails,
    )
}

fun Page<Invoice>.toInvoicePageResponse() = map { InvoicePageResponse(it) }