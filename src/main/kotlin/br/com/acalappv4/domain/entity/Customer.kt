package br.com.acalappv4.domain.entity

import br.com.acalappv4.common.enums.PersonType
import java.time.LocalDate

data class Customer(
    val id: String,
    val name: String,
    val documentNumber: DocumentNumber,

    val personType: PersonType,
    var birthDay: LocalDate? = null,

    val membershipNumber: Int,
    val phoneNumbers: List<PhoneNumber>?,
    val active: Boolean
)

data class DocumentNumber(
    val number: String
){
    override fun toString(): String = number.substring(0,3)
}

data class PhoneNumber(
    val ddd: String,
    val preferential: Boolean,
    val number: String,
    val isWhatApp: Boolean
)
