package br.com.acalappv4.resource.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "sequence")
data class SequenceDocument (

    @Id
    val id: String,

    val value: Long,

): DocumentItem

val SequenceDocument.valueString: String
    get() = this.value.toString().padStart(6, '0')
fun SequenceDocument.increment() = this.copy(value = this.value+1)
