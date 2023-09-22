package br.com.acalappv4.application.web.customer.response

import br.com.acalappv4.common.enums.PersonType
import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.PhoneNumber
import java.time.LocalDate

data class CustomerResponse (
    val id: String,
    val name: String,
    val documentNumber: String,
    val personType: PersonType,
    var birthDay: LocalDate? = null,
    val membershipNumber: String,
    val phoneNumbers: List<PhoneNumberResponse>?,
    val active: Boolean
){
    constructor(customer: Customer) : this(
        id = customer.id,
        name = customer.name,
        documentNumber = customer.documentNumber.number,
        personType = customer.personType,
        birthDay = customer.birthDay,
        membershipNumber = customer.membershipNumber,
        phoneNumbers = customer.phoneNumbers?.map { PhoneNumberResponse(it) },
        active = customer.active,
    )
}

data class PhoneNumberResponse(
    val preferential: Boolean,
    val number: String,
    val isWhatApp: Boolean
) {
    constructor(phoneNumber: PhoneNumber): this(
        preferential = phoneNumber.preferential,
        number = phoneNumber.number,
        isWhatApp = phoneNumber.isWhatApp,
    )
}
