package br.com.acalappv4.application.web.customer.request

import br.com.acalappv4.common.enums.PersonType
import java.time.LocalDate

data class UpdateCustomerRequest (
    val id: String,
    val name: String,
    val documentNumber: String,
    val personType: PersonType,
    var birthDay: LocalDate? = null,
    val membershipNumber: String,
    val phoneNumbers: List<UpdatePhoneNumberRequest>?,
    val active: Boolean,
)

data class UpdatePhoneNumberRequest(
    val number: String,
    val preferential: Boolean,
    val isWhatApp: Boolean
)

