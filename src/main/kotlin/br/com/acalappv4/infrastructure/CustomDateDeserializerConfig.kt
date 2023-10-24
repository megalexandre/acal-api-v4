package br.com.acalappv4.infrastructure

import br.com.acalappv4.infrastructure.deserializer.CustomLocalDateDeserializer
import br.com.acalappv4.infrastructure.deserializer.CustomLocalDateTimeDeserializer
import br.com.acalappv4.infrastructure.serializer.CustomLocalDateSerializer
import br.com.acalappv4.infrastructure.serializer.CustomLocalDateTimeSerializer
import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate
import java.time.LocalDateTime

@Configuration
class CustomDateDeserializerConfig(
    val objectMapper: ObjectMapper
) {
    @Bean
    fun customDateModule(): Module =
        SimpleModule().apply {

            //addDeserializer(LocalDate::class.java, CustomLocalDateDeserializer())
            //addDeserializer(LocalDateTime::class.java, CustomLocalDateTimeDeserializer())

            addSerializer(LocalDate::class.java, CustomLocalDateSerializer())
            addSerializer(LocalDateTime::class.java, CustomLocalDateTimeSerializer())

            objectMapper.registerModule(this)
        }

}


