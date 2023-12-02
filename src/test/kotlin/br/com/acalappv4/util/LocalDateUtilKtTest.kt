package br.com.acalappv4.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class LocalDateUtilKtTest {

    @Test
    fun `WHEN create a reference SHOULD pad start`() {
        val reference = LocalDate.of(2020, 1, 1).toReference()

        assertEquals("01/2020", reference.value)
    }

    @Test
    fun `WHEN get last references SHOULD return a list with all values`() {
        val references = LocalDate.of(2020, 6, 1).getLastSixMontReferences()
        assertEquals("05/2020", references[0].value)
        assertEquals("04/2020", references[1].value)
        assertEquals("03/2020", references[2].value)
        assertEquals("02/2020", references[3].value)
        assertEquals("01/2020", references[4].value)
        assertEquals("12/2019", references[5].value)
    }

}