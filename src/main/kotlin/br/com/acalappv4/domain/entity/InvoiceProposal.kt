package br.com.acalappv4.domain.entity

import java.time.LocalDateTime

class InvoiceProposal(
    val reference: Reference,
    val dueDate: LocalDateTime,
)
