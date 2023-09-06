package integration

import config.AcalAppV4ApplicationTests
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus.OK
import stub.customerStub

class CreateCustomerIntegration: AcalAppV4ApplicationTests() {

    @Test
    fun `WHEN receiver a valid customer SHOULD return 200`(){

        val header = mutableMapOf<String,String>()
        header["Content-Type"] = "application/json"

       Given {
            headers(header)
            body(gson.toJson(customerStub))
        } When {
            post("customer")
        } Then {
            statusCode(OK.value())
        }

    }

}