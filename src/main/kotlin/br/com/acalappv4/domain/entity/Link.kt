package br.com.acalappv4.domain.entity

import br.com.acalappv4.domain.entity.interfaces.Entity
import java.time.LocalDateTime

data class Link(
    val id: String,
    val category: Category,

    val address: Address,
    val addressMail: Address,

    val customer: Customer,

    val active: Boolean,
    val startedAt: LocalDateTime,
    val finishedAt: LocalDateTime?,
    val createdBy: String,
    val invoices: List<Invoice>

): Entity {

    val isOverDue: Boolean = invoices.any { it.isOverDue }

    val cancellationOfRisk: Boolean = invoices.any { it.cancellationOfRisk }

}