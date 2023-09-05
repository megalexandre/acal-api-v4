package br.com.acalappv4.application.web.customer.adapter

import br.com.acalappv4.application.web.customer.response.CustomerResponse
import br.com.acalappv4.application.web.customer.request.CustomerSaveRequest
import br.com.acalappv4.application.web.customer.request.CustomerSaveResponse
import br.com.acalappv4.application.web.customer.request.DocumentNumberSaveRequest
import br.com.acalappv4.application.web.customer.response.PhoneNumberResponse
import br.com.acalappv4.application.web.customer.request.PhoneNumberSaveRequest
import br.com.acalappv4.application.web.customer.response.CustomerPageResponse
import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.DocumentNumber
import br.com.acalappv4.domain.entity.PhoneNumber
import io.azam.ulidj.ULID
import org.springframework.data.domain.Page


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
    id = ULID.random(),
    name = name,
    documentNumber = documentNumber.toDocumentNumber(),

    personType = personType,
    birthDay = birthDay,

    membershipNumber = membershipNumber,
    phoneNumbers = phoneNumbers?.toPhoneNumber(),
    active = true,
)

fun Customer.toCustomerSaveResponse() = CustomerSaveResponse(
    id = id,
)

fun Customer.toCustomerPage() = CustomerPageResponse(
    id = id,
    name = name,
    documentNumber = documentNumber.number,
    personType = personType,
    active = active,
)

fun Page<Customer>.toCustomerPage() = map { it.toCustomerPage() }

fun Customer.toCustomerResponse() = CustomerResponse(
    id = id,
    name = name,
    documentNumber = documentNumber.number,

    personType = personType,
    birthDay = birthDay,

    membershipNumber = membershipNumber,
    phoneNumbers = phoneNumbers?.toPhoneNumberResponse(),
    active = true,
)

fun PhoneNumber.toPhoneNumberResponse() = PhoneNumberResponse(
    ddd = ddd,
    preferential = preferential,
    number = number,
    isWhatApp = isWhatApp
)

fun List<PhoneNumber>.toPhoneNumberResponse() = map { it.toPhoneNumberResponse() }