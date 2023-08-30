package br.com.acalappv4.domain.entity

import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import java.time.Duration.between
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import kotlin.math.abs

data class Invoice(
    override val id: String,
    override val active: Boolean,
    override val createdAt: LocalDateTime,
    override val updatedAt: LocalDateTime,

    val reference: Reference,
    val emission: LocalDateTime,
    val dueDate: LocalDateTime,

    val invoiceDetails: List<InvoiceDetail>,

): Entity {

    val isPayed: Boolean =
        !invoiceDetails.any { it.isAwaitingPayment }

    val totalValue: BigDecimal = if(invoiceDetails.isNotEmpty()){
        invoiceDetails
            .map { it.value }
            .reduce { acc, value -> acc + value }
    } else {
        ZERO
    }

    val payedValue: BigDecimal = if (invoiceDetails.any { it.isPayed }) {
        invoiceDetails.filter { it.isPayed }
            .map { it.value }
            .reduce { acc, value -> acc + value }
    } else {
        ZERO
    }

    val awaitingPaymentValue: BigDecimal =
        totalValue.minus(payedValue)

    val isOverDue: Boolean =
        invoiceDetails.any { it.isAwaitingPayment } && now().isAfter(dueDate)

    val overDueDays: Long = abs(between(now(), dueDate).toDays())

}


