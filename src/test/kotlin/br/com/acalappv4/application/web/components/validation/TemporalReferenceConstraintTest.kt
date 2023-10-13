package br.com.acalappv4.application.web.components.validation

import com.mongodb.assertions.Assertions.assertTrue
import org.junit.Test

class TemporalReferenceConstraintTest{

    private val temporalReferenceConstraint = TemporalReferenceConstraint()

    @Test
    fun `WHEN month is between 1 and 12 SHOULD be valid`(){

        repeat(12){
            val month = it.toString().padStart(2,'0')

            assertTrue(temporalReferenceConstraint.isValid(month + "2000", null))

        }

    }


}