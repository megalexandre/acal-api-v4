package br.com.acalappv4.domain.entity

import br.com.acalappv4.common.enums.Reason
import java.math.BigDecimal
import java.time.LocalDateTime

data class InvoiceDetail(

    val id: String,
    val reason: Reason,
    val value: BigDecimal,
    private val dataPaid: LocalDateTime?,

){
    val isPaid: Boolean = dataPaid != null
}

