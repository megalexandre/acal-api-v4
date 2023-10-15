package br.com.acalappv4.domain.entity

import java.time.LocalDateTime

class Proposal(
    val area: String,
    val invoices: List<InvoiceProposal>,
)
class InvoiceProposal(
    val reference: Reference,
    val emission: LocalDateTime,
    val linkDetail: LinkDetail,
    val address: Address,
    val invoiceDetails: List<InvoiceDetail>,
)
