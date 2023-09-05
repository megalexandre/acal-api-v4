package br.com.acalappv4.domain.usecase.customer

import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.resources.CustomerResource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import stub.customerStub
import stub.phoneNumberStub


internal class CreateCustomerUsecaseTest{

    private val customerResource = mockk<CustomerResource>()
    private val usecase = CreateCustomerUsecase(customerResource)

    @Test
    fun `WHEN create a new user SHOULD save them`(){

        every {
            customerResource.save(any())
        } returns customerStub

        every {
            customerResource.existsByDocument(any())
        } returns false

        usecase.execute(customerStub)
        verify { customerResource.save(any()) }
    }

    @Test
    fun `WHEN customer already exists SHOULD throws exception`(){

        every {
            customerResource.existsByDocument(any())
        } returns true

        assertThrows<InvalidUsecaseException> {
            usecase.execute(customerStub)
        }
    }

    @Test
    fun `WHEN customer has two preferential phone number SHOULD throws exception`(){

        val customerStubWithTwoPreferentialPhoneNumber = customerStub.copy(phoneNumbers =
            listOf(
                phoneNumberStub.copy(preferential = true),
                phoneNumberStub.copy(preferential = true)
            )
        )

        every {
            customerResource.existsByDocument(any())
        } returns false

        assertThrows<InvalidUsecaseException> {
            usecase.execute(customerStubWithTwoPreferentialPhoneNumber)
        }
    }
}