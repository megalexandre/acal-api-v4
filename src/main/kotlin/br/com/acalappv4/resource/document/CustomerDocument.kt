package br.com.acalappv4.resource.document

import br.com.acalappv4.common.enums.PersonType
import java.time.LocalDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "customer")
data class CustomerDocument (

    @Id
    val id: String,

    val name: String,
    val nameNormalized: String,

    val documentNumber: DocumentNumberDocumentItem,

    val personType: PersonType,
    var birthDay: LocalDate? = null,

    val membershipNumber: String,
    val phoneNumber: List<PhoneNumberDocumentItem>?,
    val active: Boolean
)

data class PhoneNumberDocumentItem(
    val ddd: String,
    val preferential: Boolean,
    val number: String,
    val isWhatApp: Boolean
)

data class DocumentNumberDocumentItem(
    val number: String
){
    override fun toString(): String = number.substring(0,3)
}


