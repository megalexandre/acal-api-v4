package br.com.acalappv4.application.web.customer.request

import br.com.acalappv4.common.enums.PersonType
import java.time.LocalDate

data class CustomerSaveRequest (
    val name: String,
    val documentNumber: String,
    val personType: PersonType,
    var birthDay: LocalDate? = null,
    val membershipNumber: Int,
    val phoneNumbers: List<PhoneNumberSaveRequest>?,
    val active: Boolean
)

data class PhoneNumberSaveRequest(
    val ddd: String,
    val preferential: Boolean,
    val number: String,
    val isWhatApp: Boolean
)

