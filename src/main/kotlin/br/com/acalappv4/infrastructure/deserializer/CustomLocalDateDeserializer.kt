package br.com.acalappv4.infrastructure.deserializer

import br.com.acalappv4.infrastructure.Constants.Companion.LOCAL_DATE_FORMAT
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.time.LocalDate
import java.time.LocalDate.parse
import java.time.format.DateTimeFormatter.ofPattern

class CustomLocalDateDeserializer : JsonDeserializer<LocalDate>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): LocalDate =
        parse(p.text, ofPattern(LOCAL_DATE_FORMAT))

}
