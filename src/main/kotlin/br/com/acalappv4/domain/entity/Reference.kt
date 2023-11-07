package br.com.acalappv4.domain.entity

import br.com.acalappv4.util.asReference
import br.com.acalappv4.util.toReference
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
    fun minusMonth(monthsToSubtract: Long): Reference =
         LocalDate
            .of(year.value, month, 1)
            .minusMonths(monthsToSubtract).toReference()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Reference

        if (year != other.year) return false
        if (month != other.month) return false

        return true
    }

    override fun hashCode(): Int {
        var result = year.hashCode()
        result = 31 * result + month.hashCode()
        return result
    }


    constructor(value: String): this(
        year = Year.of(value.substring(2,6).toInt()),
        month = Month.of(value.substring(0,2).toInt())
    )

    val value: String
        get() = "${month.asReference()}/${year.value}"



}