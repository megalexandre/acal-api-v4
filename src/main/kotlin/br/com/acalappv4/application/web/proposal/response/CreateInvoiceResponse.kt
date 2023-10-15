package br.com.acalappv4.application.web.proposal.response

import br.com.acalappv4.domain.entity.InvoiceDetail
import br.com.acalappv4.domain.entity.LinkDetail
import br.com.acalappv4.domain.entity.Reference
import java.time.LocalDateTime

data class CreateProposalResponse (
    val reference: Reference,
    val emission: LocalDateTime,
    val linkDetail: LinkDetail,
    val invoiceDetails: List<InvoiceDetail>,
){
}
