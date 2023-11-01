package br.com.acalappv4.domain.entity

import br.com.acalappv4.util.asReference
import java.time.LocalDate
import java.time.Month
import java.time.Year

data class Reference(
    val year: Year,
    val month: Month
) {
    companion object {
        fun getCurrent(): Reference = Reference(
            year = Year.now(),
            month = LocalDate.now().month
        )
    }

    constructor(value: String): this(
        year = Year.of(value.substring(2,6).toInt()),
        month = Month.of(value.substring(0,2).toInt())
    )

    val value: String
        get() = "${month.asReference()}/${year.value}"


}