package br.com.acalappv4.util

import java.time.LocalDate
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LocalDateUtilKtTest {

    @Test
    fun `WHEN create a reference SHOULD pad start`() {
        val reference = LocalDate.of(2020, 1, 1).toReference()

        assertEquals("012020", reference.value)
    }

    @Test
    fun `WHEN get last references SHOULD return a list with all values`() {
        val references = LocalDate.of(2020, 6, 1).getLastSixMontReferences()

        assertEquals("052020", references[0].value)
        assertEquals("042020", references[1].value)
        assertEquals("032020", references[2].value)
        assertEquals("022020", references[3].value)
        assertEquals("012020", references[4].value)
        assertEquals("122019", references[5].value)
    }

}