package br.com.acalappv4.application.web.customer

import br.com.acalappv4.common.enums.PersonType
import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.DocumentNumber
import br.com.acalappv4.domain.entity.PhoneNumber
import java.time.LocalDate
import java.util.UUID

data class CustomerSaveRequest (
    val name: String,
    val documentNumber: DocumentNumberSaveRequest,
    val personType: PersonType,
    var birthDay: LocalDate? = null,
    val membershipNumber: Int,
    val phoneNumbers: List<PhoneNumberSaveRequest>?,
    val active: Boolean
)

data class DocumentNumberSaveRequest(
    val number: String
){
    override fun toString(): String = number.substring(0,3)
}

data class PhoneNumberSaveRequest(
    val ddd: String,
    val preferential: Boolean,
    val number: String,
    val isWhatApp: Boolean
)

fun PhoneNumberSaveRequest.toPhoneNumber() = PhoneNumber(
    ddd = ddd ,
    preferential = preferential,
    number= number,
    isWhatApp = isWhatApp,
)

fun List<PhoneNumberSaveRequest>.toPhoneNumber() = map{it.toPhoneNumber()}

fun DocumentNumberSaveRequest.toDocumentNumber() = DocumentNumber(
    number = number
)

fun CustomerSaveRequest.toCustomer() = Customer(
    id = UUID.randomUUID().toString(),
    name = name,
    documentNumber = documentNumber.toDocumentNumber(),

    personType = personType,
    birthDay = birthDay,

    membershipNumber = membershipNumber,
    phoneNumbers = phoneNumbers?.toPhoneNumber(),
    active = true,
)
