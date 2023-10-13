package integration

import br.com.acalappv4.domain.entity.DocumentNumber
import br.com.acalappv4.resource.adapter.CustomerAdapter
import br.com.acalappv4.resource.repository.CustomerRepository
import config.AcalAppV4ApplicationTests
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.apache.http.HttpStatus.SC_BAD_REQUEST
import org.apache.http.HttpStatus.SC_CREATED
import org.hamcrest.Matchers.hasKey
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import stub.customerStub
import stub.phoneNumberStub
import stub.request.customer.createCustomerRequestStub

class CreateNewCustomer: AcalAppV4ApplicationTests() {

    @Autowired
    private lateinit var customerRepository: CustomerRepository;

    @Test
    fun `WHEN receiver a valid customer SHOULD return CREATED 201`(){

        val header = mutableMapOf<String,String>()
        header["Content-Type"] = "application/json"

        Given {
            headers(header)
            body(gson.toJson(createCustomerRequestStub))
        } When {
            post("customer")
        } Then {
            statusCode(SC_CREATED)
            body("$", hasKey("id"))
        }
    }

    @Test
    fun `WHEN receiver a customer with duplicated document number SHOULD return BAD_REQUEST 400`(){
        val customerWithDuplicatedDocumentNumber = customerStub.copy(
            documentNumber =  DocumentNumber(number = "10354998851")
        )

        customerRepository.save(CustomerAdapter.toDocument(customerWithDuplicatedDocumentNumber))

        val header = mutableMapOf<String,String>()
        header["Content-Type"] = "application/json"

        Given {
            headers(header)
            body(gson.toJson(customerWithDuplicatedDocumentNumber))
        } When {
            post("customer")
        } Then {
            statusCode(SC_BAD_REQUEST)
            body("$", hasKey("timestamp"))
        }
    }


    @Test
    fun `WHEN receiver a customer without preferential phone number SHOULD return BAD_REQUEST 400`(){

        val customerWithInvalidPhoneNumber = customerStub.copy(
            phoneNumbers = listOf(phoneNumberStub.copy(preferential = false))
        )

        val header = mutableMapOf<String,String>()
        header["Content-Type"] = "application/json"

        Given {
            headers(header)
            body(gson.toJson(customerWithInvalidPhoneNumber))
        } When {
            post("customer")
        } Then {
            statusCode(SC_BAD_REQUEST)
            body("$", hasKey("timestamp"))
        }
    }

}