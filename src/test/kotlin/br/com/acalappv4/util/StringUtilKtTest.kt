package br.com.acalappv4.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class StringUtilKtTest{

    @Test
    fun `WHEN receiver a string with space between words SHOULD keep them`(){
        assertEquals("socio 12", "Sócio 12".normalize())
    }

    @Test
    fun `WHEN receiver a word with acentos SHOULD return without acentos`(){
        assertEquals("socio", "Sócio".normalize())
    }

    @Test
    fun `WHEN receiver a uppercase SHOULD return lowercase`(){
        assertEquals("alexandre", "ALEXANDRE".normalize())
    }

}