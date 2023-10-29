package br.com.acalappv4.domain.entity

import br.com.acalappv4.util.asReference
import java.time.Month
import java.time.Year

class Reference(
    val year: Year,
    val month: Month
) {
    constructor(value: String): this(
        year = Year.of(value.substring(2,6).toInt()),
        month = Month.of(value.substring(0,2).toInt())
    )

    val value: String
        get() = "${month.asReference()}/${year.value}"


}