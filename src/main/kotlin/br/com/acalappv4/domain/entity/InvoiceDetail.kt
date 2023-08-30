package br.com.acalappv4.domain.entity

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.swing.text.StyledEditorKit.BoldAction

data class InvoiceDetail(
    val id: String,
    val value: BigDecimal,
    var dataPayed: LocalDateTime?,
) {

    val isPayed: Boolean = dataPayed != null
    val isAwaitingPayment: Boolean = !isPayed

}
