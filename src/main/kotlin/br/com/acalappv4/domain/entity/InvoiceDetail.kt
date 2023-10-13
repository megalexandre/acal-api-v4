package br.com.acalappv4.domain.entity

import br.com.acalappv4.common.enums.Reason
import br.com.acalappv4.domain.entity.interfaces.Entity
import java.math.BigDecimal
import java.time.LocalDateTime

data class InvoiceDetail(

    val reason: Reason,
    val value: BigDecimal,
    val dataPaid: LocalDateTime?,

) : Entity {
    val isPaid: Boolean = dataPaid != null
    val isNotPaid: Boolean = dataPaid == null
}

