package br.com.acalappv4.application.web.customer.request

import br.com.acalappv4.common.enums.PersonType
import java.time.LocalDate

data class CustomerCreateRequest (
    val name: String,
    val documentNumber: String,
    val personType: PersonType,
    var birthDay: LocalDate? = null,
    val membershipNumber: String,
    val phoneNumbers: List<PhoneNumberSaveRequest>?,
)

data class PhoneNumberSaveRequest(
    val number: String,
    val preferential: Boolean,
    val isWhatApp: Boolean
)

