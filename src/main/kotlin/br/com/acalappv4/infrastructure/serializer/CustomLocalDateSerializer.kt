package br.com.acalappv4.infrastructure.serializer

import br.com.acalappv4.infrastructure.Constants.Companion.LOCAL_DATE_FORMAT
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.time.LocalDate
import java.time.format.DateTimeFormatter.ofPattern

class CustomLocalDateSerializer : JsonSerializer<LocalDate>() {
    override fun serialize(value: LocalDate?, gen: JsonGenerator?, serializers: SerializerProvider?) {
        gen?.writeString(ofPattern(LOCAL_DATE_FORMAT).format(value))
    }

}

