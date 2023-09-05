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


internal class UpdateCustomerUsecaseTest{

    private val customerResource = mockk<CustomerResource>()
    private val usecase = UpdateCustomerUsecase(customerResource)

    @Test
    fun `WHEN update customer SHOULD save them`(){

        every {
            customerResource.save(any())
        } returns customerStub

        every {
            customerResource.findByDocument(any())
        } returns customerStub

        usecase.execute(customerStub)
        verify { customerResource.save(any()) }
    }

    @Test
    fun `WHEN document do not exists can't update and SHOULD throws exception`(){

        every {
            customerResource.findByDocument(any())
        } returns null

        assertThrows<InvalidUsecaseException> {
            usecase.execute(customerStub)
        }
    }

    @Test
    fun `WHEN document exists but ID is different SHOULD throws exception`(){

        every {
            customerResource.findByDocument(any())
        } returns customerStub.copy(id = "2")

        assertThrows<InvalidUsecaseException> {
            usecase.execute(customerStub.copy(id = "1"))
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