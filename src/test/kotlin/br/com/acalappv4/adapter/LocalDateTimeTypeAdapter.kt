package br.com.acalappv4.adapter

import com.google.gson.*
import java.lang.reflect.Type
import java.time.LocalDateTime
import java.time.LocalDateTime.parse
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ofPattern

class LocalDateTimeTypeAdapter : JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {

    private val formatter: DateTimeFormatter = ofPattern("yyyy-MM-dd HH:mm:ss")
    override fun serialize(
        date: LocalDateTime,
        typeOfSrc: Type,
        context: JsonSerializationContext
    ): JsonElement  = JsonPrimitive(date.format(formatter))

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): LocalDateTime = parse(json.asString, formatter)
}
