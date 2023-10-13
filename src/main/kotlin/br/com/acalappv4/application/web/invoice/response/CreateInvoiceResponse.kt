package br.com.acalappv4.application.web.invoice.response

import br.com.acalappv4.domain.entity.InvoiceProposal
import br.com.acalappv4.domain.entity.Reference
import java.time.LocalDateTime
import java.time.Month
import java.time.Year

data class CreateInvoiceResponse (
    val reference: String,
    val dueDate: LocalDateTime,
){
    fun toInvoiceProposal() = InvoiceProposal(
        reference = Reference(
            year = Year.of(reference.substring(3,7).toInt()),
            month = Month.of(reference.substring(0,2).toInt())
        ),
        dueDate = dueDate,
    )
}
