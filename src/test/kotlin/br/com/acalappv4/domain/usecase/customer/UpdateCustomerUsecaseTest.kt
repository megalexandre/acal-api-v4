package br.com.acalappv4.domain.usecase.customer

import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.datasource.CustomerDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import stub.customerStub
import stub.phoneNumberStub


internal class UpdateCustomerUsecaseTest{

    private val customerDataSource = mockk<CustomerDataSource>()
    private val usecase = UpdateCustomerUsecase(customerDataSource)

    @Test
    fun `WHEN update customer SHOULD save them`(){

        every {
            customerDataSource.save(any())
        } returns customerStub

        every {
            customerDataSource.findByDocument(any())
        } returns customerStub

        usecase.execute(customerStub)
        verify { customerDataSource.save(any()) }
    }

    @Test
    fun `WHEN document do not exists can't update and SHOULD throws exception`(){

        every {
            customerDataSource.findByDocument(any())
        } returns null

        assertThrows<InvalidUsecaseException> {
            usecase.execute(customerStub)
        }
    }

    @Test
    fun `WHEN document exists but ID is different SHOULD throws exception`(){

        every {
            customerDataSource.findByDocument(any())
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
            customerDataSource.existsByDocument(any())
        } returns false

        assertThrows<InvalidUsecaseException> {
            usecase.execute(customerStubWithTwoPreferentialPhoneNumber)
        }
    }


}