package br.com.acalappv4.domain.usecase.customer

import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.datasource.CustomerDataSource
import br.com.acalappv4.domain.datasource.LinkDataSource
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import stub.customerStub


internal class DeleteCustomerUsecaseTest{

    private val customerDataSource = mockk<CustomerDataSource>()
    private val linkDataSource = mockk<LinkDataSource>()

    private val usecase = DeleteCustomerUsecase(
        customerDataSource = customerDataSource,
        linkDataSource = linkDataSource
    )


    @Test
    fun `WHEN delete a customer without link SHOULD delete him`(){
        every { linkDataSource.existsByCustomer(any()) } returns false
        every { customerDataSource.delete(any()) } returns Unit

        usecase.execute(customerStub.id)
    }


    @Test
    fun `WHEN a customer has any link can't be deleted and SHOULD throw exception`(){
        every { linkDataSource.existsByCustomer(any()) } returns true
        every { customerDataSource.delete(any()) } returns Unit

        assertThrows<InvalidUsecaseException> {
            usecase.execute(customerStub.id)
        }

    }

}