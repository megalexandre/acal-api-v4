package br.com.acalappv4.application.web.invoice.response

import br.com.acalappv4.application.web.proposal.response.InvoiceNumberResponse
import br.com.acalappv4.domain.entity.Invoice
import br.com.acalappv4.domain.entity.InvoiceDetail
import br.com.acalappv4.domain.entity.LinkDetail
import br.com.acalappv4.domain.entity.Reference
import org.springframework.data.domain.Page
import java.math.BigDecimal
import java.time.LocalDateTime

class InvoicePageResponse (
    val id: String,
    val reference: Reference,
    val emission: LocalDateTime,
    val number: InvoiceNumberResponse,
    val dueDate: LocalDateTime,
    val linkDetail: LinkDetailResponse,
    val invoiceDetails: List<InvoiceDetail>,
    val totalValue: BigDecimal,
    val totalAwaitingPayment: BigDecimal,
    val totalPaidValue: BigDecimal,
    val isPayed: Boolean,
    val isOverDue: Boolean,
    val daysInOverDue: Long,
    val cancellationOfRisk: Boolean,
){
    constructor(invoice: Invoice) : this(
        id = invoice.id,
        reference = invoice.reference,
        emission = invoice.emission,
        number = InvoiceNumberResponse(invoice.invoiceNumber),
        dueDate = invoice.dueDate,
        linkDetail = LinkDetailResponse(invoice.linkDetail),
        invoiceDetails = invoice.invoiceDetails,
        totalValue = invoice.totalValue,
        totalAwaitingPayment = invoice.totalAwaitingPayment,
        totalPaidValue = invoice.totalPaidValue,
        isPayed = invoice.isPayed,
        isOverDue = invoice.isOverDue,
        daysInOverDue = invoice.daysInOverDue,
        cancellationOfRisk = invoice.cancellationOfRisk,
    )
}

data class LinkDetailResponse(
    val linkId: String,
    val customer: String,
    val address: String,
){
    constructor(linkDetail: LinkDetail): this(
        linkId = linkDetail.linkId,
        customer = linkDetail.customer,
        address = linkDetail.address
    )
}

fun Page<Invoice>.toInvoicePageResponse() = map { InvoicePageResponse(it) }