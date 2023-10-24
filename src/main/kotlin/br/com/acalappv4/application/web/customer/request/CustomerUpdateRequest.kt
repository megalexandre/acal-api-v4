package br.com.acalappv4.application.web.customer.request

import br.com.acalappv4.common.enums.PersonType
import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.DocumentNumber
import br.com.acalappv4.domain.entity.PhoneNumber
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
){
    fun toEntity() = Customer(
        id = id,
        name = name,
        documentNumber = DocumentNumber(number = documentNumber),
        personType = personType,
        birthDay = birthDay,
        membershipNumber = membershipNumber,
        phoneNumbers = phoneNumbers?.let { phoneNumbers.map { it.toEntity() }},
        active = active,
    )
}

data class UpdatePhoneNumberRequest(
    val number: String,
    val preferential: Boolean,
    val isWhatApp: Boolean
){
    fun toEntity(): PhoneNumber =
        PhoneNumber(
            preferential = preferential,
            number= number,
            isWhatApp = isWhatApp,
        )
}

