package br.com.acalappv4.infrastructure.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CustomLocalDateDeserializer : JsonDeserializer<LocalDate>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): LocalDate =
        LocalDate.parse(p.text, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
}
