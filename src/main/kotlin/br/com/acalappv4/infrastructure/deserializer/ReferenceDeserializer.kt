package br.com.acalappv4.infrastructure.deserializer

import br.com.acalappv4.domain.entity.Reference
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.time.Month
import java.time.Year

class ReferenceDeserializer : JsonDeserializer<Reference>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Reference =

        when(p.text.length){
            6 -> Reference(Year.of(p.text.substring(2,6).toInt()), Month.of(p.text.substring(0,2).toInt()))
            else ->  Reference(Year.of(p.text.substring(3,7).toInt()), Month.of(p.text.substring(0,2).toInt()))
        }


}
