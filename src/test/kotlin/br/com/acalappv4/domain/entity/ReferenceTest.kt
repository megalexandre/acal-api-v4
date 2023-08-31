package br.com.acalappv4.domain.entity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ReferenceTest{

    @Test
    fun `WHEN create a reference SHOULD return length equals six`(){
        val reference = Reference(year ="2023", month = "1")

        assertEquals("012023", reference.value)
        assertEquals(6, reference.value.length)
    }
}