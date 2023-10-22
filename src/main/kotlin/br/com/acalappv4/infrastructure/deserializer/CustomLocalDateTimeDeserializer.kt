package br.com.acalappv4.infrastructure.deserializer

import br.com.acalappv4.infrastructure.Constants
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.time.LocalDateTime
import java.time.LocalDateTime.parse
import java.time.format.DateTimeFormatter.ofPattern

class CustomLocalDateTimeDeserializer : JsonDeserializer<LocalDateTime>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): LocalDateTime =
        parse(p.text, ofPattern(Constants.LOCAL_DATE_FORMAT))

}