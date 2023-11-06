package br.com.acalappv4.application.web.proposal.request

import br.com.acalappv4.domain.entity.Reference
import java.time.Month
import java.time.Year

data class ReferenceRequest (
    val reference: String,
){

    fun toReference()=
        Reference(
            year = Year.of(reference.substring(2,6).toInt()),
            month = Month.of(reference.substring(0,2).toInt())
        )
}
