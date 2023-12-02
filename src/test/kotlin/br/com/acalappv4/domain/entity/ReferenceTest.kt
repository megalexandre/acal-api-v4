package br.com.acalappv4.domain.entity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.Month
import java.time.Year

internal class ReferenceTest{

    @Test
    fun `WHEN create a reference SHOULD write correctly`(){
        val reference = Reference(year = Year.of(2023), month = Month.JANUARY)
        assertEquals("01/2023", reference.value)
    }



}