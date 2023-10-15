package br.com.acalappv4.domain.entity

import br.com.acalappv4.domain.entity.interfaces.Entity
import java.time.Year

class InvoiceNumber(
    val year: Year,
    val number: String,
): Entity