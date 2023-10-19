package br.com.acalappv4.application.web.invoice.request

import br.com.acalappv4.domain.entity.*
import io.azam.ulidj.ULID
import java.time.LocalDate
import java.time.LocalDateTime

data class CreateInvoiceRequest (
    val reference: Reference,
    val emission: LocalDateTime,
    val dueDate: LocalDateTime,
    val linkDetail: LinkDetail,
    val invoiceDetails: List<InvoiceDetail>,
){
    fun toInvoice() = Invoice(
        id = ULID.random(),
        reference = reference,
        emission = emission,
        dueDate = dueDate,
        linkDetail = linkDetail,
        invoiceDetails = invoiceDetails,
    )
}

