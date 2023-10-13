package br.com.acalappv4.infrastructure.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ofPattern

class CustomLocalDateTimeSerializer : JsonSerializer<LocalDateTime>() {

    override fun serialize(value: LocalDateTime?, gen: JsonGenerator?, serializers: SerializerProvider?) {
        gen?.writeString(ofPattern("yyyy-MM-dd HH:mm:ss").format(value))
    }

}

