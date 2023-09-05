package br.com.acalappv4.application.web.customer.response

import br.com.acalappv4.common.enums.PersonType
import java.time.LocalDate

data class CustomerResponse (
    val id: String,
    val name: String,
    val documentNumber: String,
    val personType: PersonType,
    var birthDay: LocalDate? = null,
    val membershipNumber: Int,
    val phoneNumbers: List<PhoneNumberResponse>?,
    val active: Boolean
)

data class PhoneNumberResponse(
    val ddd: String,
    val preferential: Boolean,
    val number: String,
    val isWhatApp: Boolean
)
