package br.com.acalappv4.domain.entity

import java.time.LocalDateTime

class InvoiceProposal(
    val area: String,
    val invoices: List<InvoiceProposalItem>,
)

class InvoiceProposalItem(
    val number: InvoiceNumber,
    val reference: Reference,
    val emission: LocalDateTime,
    val linkDetail: LinkDetail,
    val address: Address,
    val invoiceDetails: List<InvoiceDetail>,
){
    val total = invoiceDetails.map { it.value }.sumOf { it }
    val addressName = address.area.name +"/"+ address.letter + address.number
}
