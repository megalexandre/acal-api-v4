package br.com.acalappv4.domain.entity

import java.time.Month
import java.time.Year

class Reference(
    val year: Year,
    val month: Month
) {

    val value: String
        get() = "${month.value.toString().padStart(2,'0')}/${year.value}"

}