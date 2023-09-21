package br.com.acalappv4.application.web.customer.adapter

import br.com.acalappv4.application.web.customer.response.CreateCustomerResponse
import br.com.acalappv4.application.web.customer.request.CustomerCreateRequest
import br.com.acalappv4.application.web.customer.request.PhoneNumberSaveRequest
import br.com.acalappv4.application.web.customer.response.CustomerPageResponse
import br.com.acalappv4.application.web.customer.response.CustomerResponse
import br.com.acalappv4.application.web.customer.response.PhoneNumberResponse
import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.DocumentNumber
import br.com.acalappv4.domain.entity.PhoneNumber
import io.azam.ulidj.ULID
import org.springframework.data.domain.Page


class PhoneNumberRequestAdapter {
    companion object{

        fun toEntity(request: PhoneNumberSaveRequest): PhoneNumber = with(request){
            PhoneNumber(
                preferential = preferential,
                number= number,
                isWhatApp = isWhatApp,
            )
        }

    }

}

fun List<PhoneNumberSaveRequest>.toPhoneNumber() = map{PhoneNumberRequestAdapter.toEntity(it)}

fun CustomerCreateRequest.toCustomer() = Customer(
    id = ULID.random(),
    name = name,
    documentNumber = DocumentNumber(number = documentNumber),
    personType = personType,
    birthDay = birthDay,

    membershipNumber = membershipNumber,
    phoneNumbers = phoneNumbers?.toPhoneNumber(),
    active = true,
)

fun Customer.toCustomerSaveResponse() = CreateCustomerResponse(
    id = id,
)

fun Customer.toCustomerPage() = CustomerPageResponse(
    id = id,
    name = name,
    documentNumber = documentNumber.number,
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
    preferential = preferential,
    number = number,
    isWhatApp = isWhatApp
)

fun List<PhoneNumber>.toPhoneNumberResponse() = map { it.toPhoneNumberResponse() }