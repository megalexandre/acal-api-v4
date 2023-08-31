package br.com.acalappv4.domain.entity

import java.math.BigDecimal
import java.time.LocalDateTime

data class Invoice(
    val reference: Reference,
    val emission: LocalDateTime,
    val dueDate: LocalDateTime,
    val invoiceDetails: List<InvoiceDetail>
) {

    val totalValue: BigDecimal = invoiceDetails
        .sumOf { it.value }

    val totalAwaitingPayment: BigDecimal = invoiceDetails
        .filter { it.isNotPaid }
        .sumOf { it.value }

    val totalPaidValue: BigDecimal = totalValue
        .minus(totalAwaitingPayment)

    val isPayed: Boolean = !invoiceDetails
        .any { it.isNotPaid }

    val isOverDue: Boolean = false
}