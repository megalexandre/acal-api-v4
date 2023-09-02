package br.com.acalappv4.domain.entity

import br.com.acalappv4.common.enums.PersonType
import java.time.LocalDate

data class Customer(
    val id: String,
    val name: String,
    val document: Document,

    val personType: PersonType,
    var birthDay: LocalDate? = null,

    val membershipNumber: Int,
    val phoneNumber: List<Phone>?,
    val active: Boolean
)

data class Document(
    val number: String
){
    override fun toString(): String = number.substring(0,3)
}

data class Phone(
    val ddd: String,
    val number: String,
    val isWhatApp: Boolean
)
