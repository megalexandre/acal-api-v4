package br.com.acalappv4.adapter

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type
import java.time.LocalDate
import java.time.LocalDate.parse
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ofPattern

class LocalDateTypeAdapter : JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    private val formatter: DateTimeFormatter = ofPattern("yyyy-MM-dd")

    override fun serialize(
        date: LocalDate,
        typeOfSrc: Type,
        context: JsonSerializationContext
    ): JsonElement  = JsonPrimitive(date.format(formatter))

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): LocalDate = parse(json.asString, formatter)
}
