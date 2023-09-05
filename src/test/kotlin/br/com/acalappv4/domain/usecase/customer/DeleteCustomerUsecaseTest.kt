package br.com.acalappv4.domain.usecase.customer

import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.resources.CustomerResource
import br.com.acalappv4.domain.resources.LinkResource
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import stub.customerStub


internal class DeleteCustomerUsecaseTest{

    private val customerResource = mockk<CustomerResource>()
    private val linkResource = mockk<LinkResource>()

    private val usecase = DeleteCustomerUsecase(
        customerResource = customerResource,
        linkResource = linkResource
    )


    @Test
    fun `WHEN delete a customer without link SHOULD delete him`(){
        every { linkResource.existsByCustomer(any()) } returns false
        every { customerResource.delete(any()) } returns Unit

        usecase.execute(customerStub.id)
    }


    @Test
    fun `WHEN a customer has any link can't be deleted and SHOULD throw exception`(){
        every { linkResource.existsByCustomer(any()) } returns true
        every { customerResource.delete(any()) } returns Unit

        assertThrows<InvalidUsecaseException> {
            usecase.execute(customerStub.id)
        }

    }

}