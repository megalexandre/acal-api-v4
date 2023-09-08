package br.com.acalappv4.util

import br.com.acalappv4.domain.entity.Reference
import java.time.LocalDate

fun LocalDate.toReference() = Reference(
    month = this.monthValue.toString().padStart(2, '0'),
    year = this.year.toString()
)

fun LocalDate.getLastSixMontReferences(): List<Reference> =
     (1L..6L).map { monthsAgo ->
        this.minusMonths(monthsAgo).toReference()
    }


