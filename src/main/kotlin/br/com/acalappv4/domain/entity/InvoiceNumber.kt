package br.com.acalappv4.domain.entity

import br.com.acalappv4.domain.entity.interfaces.Entity
import br.com.acalappv4.util.asReference
import java.time.Month
import java.time.Year

class InvoiceNumber(
    val year: Year,
    val month: Month,
    val number: String,
): Entity {
    val value: String
        get() = "${month.asReference()}.${year.value}/$number"
}
