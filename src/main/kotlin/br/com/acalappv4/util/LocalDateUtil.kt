package br.com.acalappv4.util

import br.com.acalappv4.domain.entity.Reference
import java.time.LocalDate
import java.time.Month
import java.time.Year

fun LocalDate.toReference() = Reference(
    month = Month.from(this),
    year = Year.from(this)
)

fun LocalDate.getLastSixMontReferences(): List<Reference> =
     (1L..6L).map { monthsAgo ->
        this.minusMonths(monthsAgo).toReference()
    }


