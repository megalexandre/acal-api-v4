package br.com.acalappv4.application.web.customer.response

import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.PhoneNumber


class CustomerResponseAdapter {
    companion object{
        fun toResponse(customer: Customer): CustomerResponse = CustomerResponse(
            id = customer.id,
            name = customer.name,
            documentNumber = customer.documentNumber.number,
            personType = customer.personType,
            birthDay = customer.birthDay,
            membershipNumber = customer.membershipNumber,
            phoneNumbers = customer.phoneNumbers?.let {PhoneNumberResponseAdapter.toResponse(customer.phoneNumbers)},
            active = customer.active,
        )

    }
}

class PhoneNumberResponseAdapter {
    companion object{

        fun toResponse(phoneNumber: PhoneNumber): PhoneNumberResponse =
            PhoneNumberResponse(
                preferential = phoneNumber.preferential,
                number = phoneNumber.number,
                isWhatApp = phoneNumber.isWhatApp
            )

        fun toResponse(phoneNumbers: List<PhoneNumber>): List<PhoneNumberResponse> =
            phoneNumbers.map { toResponse(it) }
    }
}
