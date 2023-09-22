package br.com.acalappv4.application.web.customer.request

import br.com.acalappv4.application.web.customer.response.CustomerPageResponse
import br.com.acalappv4.application.web.customer.response.PhoneNumberResponse
import br.com.acalappv4.domain.dto.PageFilterCustomer
import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.DocumentNumber
import br.com.acalappv4.domain.entity.PhoneNumber
import io.azam.ulidj.ULID
import org.springframework.data.domain.Page

class CustomerPageRequestAdapter {

    companion object{
        fun toEntity(request: CustomerPageRequest): PageFilterCustomer = with(request) {
            PageFilterCustomer(
                id = id,
                name =  name,
                documentNumber = documentNumber,
                personType = personType,
                active = active,
                page = page,
                sort = sort
            )
        }
    }
}

class UpdateCreateRequestAdapter{
    companion object{
        fun toEntity(request: UpdateCustomerRequest): Customer = with(request){
            Customer(
                id = id,
                name = name,
                documentNumber = DocumentNumber(number = documentNumber),
                personType = personType,
                birthDay = birthDay,
                membershipNumber = membershipNumber,
                phoneNumbers = phoneNumbers?.let { UpdatePhoneNumberRequestAdapter.toEntity(phoneNumbers) },
                active = active,
            )
        }
    }
}

class UpdatePhoneNumberRequestAdapter{
    companion object{
        fun toEntity(request: UpdatePhoneNumberRequest): PhoneNumber = with(request){
            PhoneNumber(
                preferential = preferential,
                number = number,
                isWhatApp = isWhatApp,
            )
        }
        fun toEntity(request: List<UpdatePhoneNumberRequest>): List<PhoneNumber> = request.map { toEntity(it) }
    }
}


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


fun List<PhoneNumberSaveRequest>.toPhoneNumber() = map{ PhoneNumberRequestAdapter.toEntity(it) }

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


fun Customer.toCustomerPage() = CustomerPageResponse(
    id = id,
    name = name,
    documentNumber = documentNumber.number,
)

fun Page<Customer>.toCustomerPage() = map { it.toCustomerPage() }


