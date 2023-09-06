package integration

import config.AcalAppV4ApplicationTests
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.apache.http.HttpStatus.SC_CREATED
import org.hamcrest.Matchers.hasKey
import org.junit.jupiter.api.Test
import stub.customerStub

class CreateNewCustomer: AcalAppV4ApplicationTests() {

    @Test
    fun `WHEN receiver a valid customer SHOULD return CREATED 201`(){

        val header = mutableMapOf<String,String>()
        header["Content-Type"] = "application/json"

        Given {
            headers(header)
            body(gson.toJson(customerStub))
        } When {
            post("customer")
        } Then {
            statusCode(SC_CREATED)
            body("$", hasKey("id"))
        }

    }

}