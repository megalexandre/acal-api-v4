package br.com.acalappv4.domain.entity

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import stub.customerStub
import stub.phoneNumberStub

internal class CustomerTest{

    @Test
    fun `WHEN a customer has no one phone number SHOULD be phone number valid`(){

        val customerWithNoOnePhoneNumber: Customer = customerStub.copy(phoneNumbers = null)

        assertTrue(customerWithNoOnePhoneNumber.isValidPhoneNumbers)
    }

    @Test
    fun `WHEN a customer has any phone number SHOULD has only one preferential`(){
        val customerWithManyPhoneNumber = customerStub.copy(phoneNumbers =
            listOf(
                phoneNumberStub.copy(preferential = true),
                phoneNumberStub.copy(preferential = false),
                phoneNumberStub.copy(preferential = false),
                phoneNumberStub.copy(preferential = false),
            )
        )

        assertTrue(customerWithManyPhoneNumber.isValidPhoneNumbers)
    }

    @Test
    fun `WHEN a customer has more than one preferential phone number SHOULD be invalid`(){
        val customerWithMoreThanOnePreferentialPhoneNumber = customerStub.copy(phoneNumbers =
        listOf(
            phoneNumberStub.copy(preferential = true),
            phoneNumberStub.copy(preferential = true),
            )
        )

        assertFalse(customerWithMoreThanOnePreferentialPhoneNumber.isValidPhoneNumbers)
    }


}