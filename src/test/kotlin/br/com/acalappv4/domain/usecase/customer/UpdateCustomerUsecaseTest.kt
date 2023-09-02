package br.com.acalappv4.domain.usecase.customer

import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.resources.customer.CustomerResource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import stub.customerStub


internal class UpdateCustomerUsecaseTest{

    private val customerResource = mockk<CustomerResource>()
    private val usecase = UpdateCustomerUsecase(customerResource)

    @Test
    fun `WHEN update user SHOULD save them`(){

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

}