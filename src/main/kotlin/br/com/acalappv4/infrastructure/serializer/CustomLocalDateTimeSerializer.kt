package br.com.acalappv4.infrastructure.serializer

import br.com.acalappv4.infrastructure.Constants.Companion.LOCAL_DATE_TIME_FORMAT
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter.ofPattern

class CustomLocalDateTimeSerializer : JsonSerializer<LocalDateTime>() {
    override fun serialize(value: LocalDateTime?, gen: JsonGenerator?, serializers: SerializerProvider?) {
        gen?.writeString(ofPattern(LOCAL_DATE_TIME_FORMAT).format(value?.atZone(ZoneId.of("America/Sao_Paulo"))))
    }

}



