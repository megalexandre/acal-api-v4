package br.com.acalappv4.domain.entity

import br.com.acalappv4.common.Category
import br.com.acalappv4.util.getLastSixMontReferences
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDate.now
import java.time.LocalDateTime

class Link(
    override val id: String,
    override val active: Boolean,
    override val createdAt: LocalDateTime,
    override val updatedAt: LocalDateTime,

    private val category: Category,
    private val invoices: List<Invoice>,

): Entity {

    val cutNotice: Boolean =
        invoices
            .any { it.overDueDays > 59 }

    val awaitingPaymentValue: BigDecimal =
        invoices
            .map { it.awaitingPaymentValue }
            .reduce { _, value -> value }


    val hasLastSixMonthInvoices: Boolean =
        now().getLastSixMontReferences().filter { reference ->
            invoices.any{ it.reference == reference }
        }.size == 6

}