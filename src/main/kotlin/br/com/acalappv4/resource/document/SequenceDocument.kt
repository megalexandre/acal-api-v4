package br.com.acalappv4.resource.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "sequence")
data class SequenceDocument (

    @Id
    val id: String,

    val name: String,

    val value: Long,

): DocumentItem