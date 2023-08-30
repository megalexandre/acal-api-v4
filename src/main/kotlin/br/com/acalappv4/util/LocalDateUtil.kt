package br.com.acalappv4.util

import br.com.acalappv4.domain.entity.Reference
import java.time.LocalDate

fun LocalDate.toReference() = Reference(
    month = this.monthValue.toString().padStart(2, '0'),
    year = this.year.toString()
)

fun LocalDate.getLastSixMontReferences(): List<Reference> =
    listOf<Reference>()
        .asSequence()
            .plus(this.minusMonths(1).toReference())
            .plus(this.minusMonths(2).toReference())
            .plus(this.minusMonths(3).toReference())
            .plus(this.minusMonths(4).toReference())
            .plus(this.minusMonths(5).toReference())
            .plus(this.minusMonths(6).toReference())
        .toList()




