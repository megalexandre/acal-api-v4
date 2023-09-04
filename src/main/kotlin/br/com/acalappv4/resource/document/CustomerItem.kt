package br.com.acalappv4.resource.document

import br.com.acalappv4.common.enums.PersonType
import java.time.LocalDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "customer")
class CustomerItem (

    @Id
    val id: String,

    val name: String,
    val documentNumber: DocumentNumberItem,

    val personType: PersonType,
    var birthDay: LocalDate? = null,

    val membershipNumber: Int,
    val phoneNumber: List<PhoneNumberItem>?,
    val active: Boolean
)

data class PhoneNumberItem(
    val ddd: String,
    val preferential: Boolean,
    val number: String,
    val isWhatApp: Boolean
)

data class DocumentNumberItem(
    val number: String
){
    override fun toString(): String = number.substring(0,3)
}


