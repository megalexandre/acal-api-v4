package br.com.acalappv4.domain.entity

import br.com.acalappv4.ImpedimentToVoting
import br.com.acalappv4.common.PersonType
import java.time.LocalDate
import java.time.LocalDateTime

class Customer(

    override val id: String,
    override val active: Boolean,
    override val createdAt: LocalDateTime,
    override val updatedAt: LocalDateTime,

    val name: String,
    val document: Document,
    val membershipNumber: Int,

    var birthDay: LocalDate? = null,
    val phoneNumber: List<Number>?,

    val personType: PersonType,
    val link: List<Link>?,

) : Entity {

    fun canVote(): Boolean = false

    fun impedimentsToVoting(): List<ImpedimentToVoting> =
        ImpedimentToVoting.values().toList()

}

class PhoneNumber(
    val ddd: String,
    val number: String,
)

class Document(
    val number: String
)

