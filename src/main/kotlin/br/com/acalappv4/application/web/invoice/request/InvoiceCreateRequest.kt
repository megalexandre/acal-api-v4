package br.com.acalappv4.application.web.invoice.request

import br.com.acalappv4.domain.entity.*
import io.azam.ulidj.ULID
import io.azam.ulidj.ULID.random
import java.time.LocalDateTime
import java.time.Month
import java.time.Year

data class InvoiceCreateRequest (
    val reference: Reference,
    val emission: LocalDateTime,
    val dueDate: LocalDateTime,
    val linkDetail: LinkDetail,
    val number: InvoiceNumberRequest,
    val invoiceDetails: List<InvoiceDetail>,
){
    fun toInvoice() = Invoice(
        id = random(),
        reference = reference,
        emission = emission,
        invoiceNumber = number.toInvoiceNumber(),
        dueDate = dueDate,
        linkDetail = linkDetail,
        invoiceDetails = invoiceDetails,
    )
}

data class InvoiceNumberRequest(
    val year: Year,
    val month: Month,
    val number: String
){
    fun toInvoiceNumber() = InvoiceNumber(
        year = year,
        month = month,
        number = number
    )
}