package br.com.acalappv4.application.web.customer.request

import br.com.acalappv4.common.enums.PersonType
import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.DocumentNumber
import br.com.acalappv4.domain.entity.PhoneNumber
import io.azam.ulidj.ULID
import java.time.LocalDate

data class CustomerSaveRequest (
    val name: String,
    val documentNumber: DocumentNumberSaveRequest,
    val personType: PersonType,
    var birthDay: LocalDate? = null,
    val membershipNumber: Int,
    val phoneNumbers: List<PhoneNumberSaveRequest>?,
    val active: Boolean
)

data class DocumentNumberSaveRequest(
    val number: String
){
    override fun toString(): String = number.substring(0,3)
}

data class PhoneNumberSaveRequest(
    val ddd: String,
    val preferential: Boolean,
    val number: String,
    val isWhatApp: Boolean
)

