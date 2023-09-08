package br.com.acalappv4.resource.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "address")
class AddressDocument(

    @Id
    val id: String,

    val area: AreaDocument,

    val number: Long,

    val letter: String,

    val hasHydrometer: Boolean,

) : DocumentItem
