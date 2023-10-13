package br.com.acalappv4.infrastructure.serializer

import br.com.acalappv4.domain.entity.Reference
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider

class ReferenceSerializer : JsonSerializer<Reference>() {

    override fun serialize(value: Reference?, gen: JsonGenerator?, serializers: SerializerProvider?) {
        value?.let {gen?.writeString(it.value) } ?: {""}
    }

}

