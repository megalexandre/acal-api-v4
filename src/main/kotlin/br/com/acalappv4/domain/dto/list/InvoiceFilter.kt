package br.com.acalappv4.domain.dto.list

import br.com.acalappv4.domain.entity.Reference
import java.time.LocalDateTime

class InvoiceFilter(
    val id: String? = null,
    val linkId: String? = null,
    val reference: Reference? = null,
    val customerName: String? = null,
    val addressName: String? = null,
    val dueDate: LocalDateTime? = null,
): DefaultFilter

