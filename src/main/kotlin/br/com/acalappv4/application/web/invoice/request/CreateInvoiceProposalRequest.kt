package br.com.acalappv4.application.web.invoice.request

import br.com.acalappv4.application.web.components.validation.ValidReference
import br.com.acalappv4.domain.entity.InvoiceProposal
import br.com.acalappv4.domain.entity.Reference
import org.springframework.validation.annotation.Validated
import java.time.LocalDateTime

@Validated
data class CreateInvoiceProposalRequest (
    @ValidReference
    val reference: Reference,
    val dueDate: LocalDateTime,
){
    fun toInvoiceProposal() = InvoiceProposal(
        reference = reference,
        dueDate = dueDate,
    )
}
