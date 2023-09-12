package br.com.acalappv4.resource.adapter

import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.DocumentNumber
import br.com.acalappv4.domain.entity.PhoneNumber
import br.com.acalappv4.resource.document.CustomerDocument
import br.com.acalappv4.resource.document.DocumentNumberDocumentItem
import br.com.acalappv4.resource.document.PhoneNumberDocumentItem
import br.com.acalappv4.util.normalize
import org.springframework.data.domain.Page

class CustomerAdapter{

    companion object: ResourceAdapter<CustomerDocument, Customer> {

        override fun toEntity(document: CustomerDocument): Customer = with(document){
            Customer(
                id = id,
                name = name,
                documentNumber = documentNumber.toDocumentNumber(),
                personType = personType,
                birthDay = birthDay,
                membershipNumber = membershipNumber,
                phoneNumbers = phoneNumber?.toPhoneNumber(),
                active = active,
            )
        }

        override fun toDocument(entity: Customer): CustomerDocument = with(entity){
            CustomerDocument(
                id = id,
                name = name,
                nameNormalized = name.normalize(),
                documentNumber = documentNumber.toDocumentNumber(),
                personType = personType,
                birthDay = birthDay,
                membershipNumber = membershipNumber,
                phoneNumber = phoneNumbers?.toPhoneNumberItem(),
                active = active,
            )

        }

    }
}

fun Page<CustomerDocument>.toCustomer() = map { CustomerAdapter.toEntity(it)  }

fun DocumentNumberDocumentItem.toDocumentNumber() = DocumentNumber(
    number = number
)

fun PhoneNumberDocumentItem.toPhoneNumber() = PhoneNumber(
    ddd = ddd,
    number = number,
    preferential = preferential,
    isWhatApp = isWhatApp
)

fun List<PhoneNumberDocumentItem>.toPhoneNumber() = map { it.toPhoneNumber() }

fun DocumentNumber.toDocumentNumber() = DocumentNumberDocumentItem(
    number = number
)

fun PhoneNumber.toPhoneNumberItem() = PhoneNumberDocumentItem(
    ddd = ddd,
    number = number,
    preferential = preferential,
    isWhatApp = isWhatApp
)

fun List<PhoneNumber>.toPhoneNumberItem(): List<PhoneNumberDocumentItem> = map { it.toPhoneNumberItem() }



