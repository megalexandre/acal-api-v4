package br.com.acalappv4.application.web.proposal.response

import br.com.acalappv4.common.enums.Reason
import br.com.acalappv4.domain.entity.*
import br.com.acalappv4.domain.entity.interfaces.Entity
import java.math.BigDecimal
import java.time.LocalDateTime

data class CreateProposalResponse (
    val area: String,
    val invoices: List<InvoiceProposalResponse>,
){
    constructor(proposal: Proposal): this(
        area = proposal.area,
        invoices = proposal.invoices.map { InvoiceProposalResponse(it) }
    )

}
class InvoiceProposalResponse(
    val reference: Reference,
    val emission: LocalDateTime,
    val linkDetail: LinkDetailResponse,
    val address: Address,
    val invoiceDetails: List<InvoiceDetailResponse>,
){
    constructor(invoiceProposal: InvoiceProposal): this(
        reference = invoiceProposal.reference,
        emission = invoiceProposal.emission,
        linkDetail =LinkDetailResponse(invoiceProposal.linkDetail),
        address = invoiceProposal.address,
        invoiceDetails = invoiceProposal.invoiceDetails.map { InvoiceDetailResponse(it) }
    )

    val total = invoiceDetails.map { it.value }.sumOf { it }
    val addressName = address.letter +"/" + address.number
}
data class LinkDetailResponse(
    val linkId: String,
    val customer: String,
    val address: String,
){
    constructor(linkDetail: LinkDetail): this(
        linkId = linkDetail.linkId,
        customer = linkDetail.customer,
        address = linkDetail.address,
    )
}

data class InvoiceDetailResponse(

    val reason: Reason,
    val value: BigDecimal,
    val dataPaid: LocalDateTime?,

    ) : Entity {

    constructor(invoiceDetail: InvoiceDetail): this(
        reason = invoiceDetail.reason,
        value = invoiceDetail.value,
        dataPaid = invoiceDetail.dataPaid,
    )

    val isPaid: Boolean = dataPaid != null
    val isNotPaid: Boolean = dataPaid == null
}
