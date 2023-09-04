package br.com.acalappv4.resource.adapter

import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.DocumentNumber
import br.com.acalappv4.domain.entity.PhoneNumber
import br.com.acalappv4.resource.document.CustomerItem
import br.com.acalappv4.resource.document.DocumentNumberItem
import br.com.acalappv4.resource.document.PhoneNumberItem

fun DocumentNumberItem.toDocumentNumber() = DocumentNumber(
    number = number
)

fun PhoneNumberItem.toPhoneNumber() = PhoneNumber(
    ddd = ddd,
    number = number,
    preferential = preferential,
    isWhatApp = isWhatApp
)

fun List<PhoneNumberItem>.toPhoneNumber() = map { it.toPhoneNumber() }

fun CustomerItem.toCustomer() = Customer(
    id = id,
    name = name,
    documentNumber = documentNumber.toDocumentNumber(),
    personType = personType,
    birthDay = birthDay,
    membershipNumber = membershipNumber,
    phoneNumbers = phoneNumber?.toPhoneNumber(),
    active = active,
)

fun DocumentNumber.toDocumentNumber() = DocumentNumberItem(
    number = number
)

fun PhoneNumber.toPhoneNumberItem() = PhoneNumberItem(
    ddd = ddd,
    number = number,
    preferential = preferential,
    isWhatApp = isWhatApp
)

fun List<PhoneNumber>.toPhoneNumberItem(): List<PhoneNumberItem> = map { it.toPhoneNumberItem() }


fun Customer.toCustomerItem() = CustomerItem(
    id = id,
    name = name,
    documentNumber = documentNumber.toDocumentNumber(),
    personType = personType,
    birthDay = birthDay,
    membershipNumber = membershipNumber,
    phoneNumber = phoneNumbers?.toPhoneNumberItem(),
    active = active,
)

