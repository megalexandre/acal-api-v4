package br.com.acalappv4.infrastructure.deserializer

import br.com.acalappv4.infrastructure.Constants.Companion.LOCAL_DATE_TIME_FORMAT
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.time.LocalDateTime
import java.time.LocalDateTime.parse
import java.time.format.DateTimeFormatter.ofPattern

class CustomLocalDateTimeDeserializer : JsonDeserializer<LocalDateTime>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): LocalDateTime =
       parse(p.text, ofPattern(LOCAL_DATE_TIME_FORMAT))

}