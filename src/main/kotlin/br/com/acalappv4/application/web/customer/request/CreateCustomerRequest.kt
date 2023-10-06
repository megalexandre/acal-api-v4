package br.com.acalappv4.application.web.customer.request

import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.DocumentNumber
import br.com.acalappv4.domain.entity.PhoneNumber
import io.azam.ulidj.ULID
import java.time.LocalDate

data class CustomerCreateRequest (
    val name: String,
    val documentNumber: String,
    var birthDay: LocalDate? = null,
    val membershipNumber: String,
    val phoneNumbers: List<PhoneNumberSaveRequest>?,
){
    fun toCustomer() = Customer(
        id = ULID.random(),
        name = name,
        documentNumber = DocumentNumber(number = documentNumber),
        personType = DocumentNumber(number = documentNumber).personType,
        birthDay = birthDay,
        membershipNumber = membershipNumber,
        phoneNumbers = phoneNumbers?.map { it.toEntity() },
        active = true,
    )
}

data class PhoneNumberSaveRequest(
    val number: String,
    val preferential: Boolean,
    val isWhatApp: Boolean
){
    fun toEntity() = PhoneNumber(
        number = number,
        preferential = preferential,
        isWhatApp = isWhatApp
    )
}

