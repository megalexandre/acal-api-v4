package br.com.acalappv4.resource.document

import java.time.LocalDateTime
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "link")
data class LinkDocument (

    @Id
    val id: String,

    val customer: CustomerDocument,

    val category: CategoryDocument,

    val address: AddressDocument,

    val addressMail: AddressDocument,

    val active: Boolean,

    val startedAt: LocalDateTime,

    val finishedAt: LocalDateTime?,

    val createdBy: String,
)

