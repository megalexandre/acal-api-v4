package integration

import config.AcalAppV4ApplicationTests
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.apache.http.HttpStatus.SC_CREATED
import org.hamcrest.Matchers.hasKey
import org.junit.jupiter.api.Test
import stub.request.invoice.createInvoiceProposalRequestStub

class ListInvoiceProposal: AcalAppV4ApplicationTests() {

    @Test
    fun `WHEN receiver request and has not link SHOULD return CREATED 201 with empty list`(){
        val header = mutableMapOf<String,String>()
        header["Content-Type"] = "application/json"

        val body = gson.toJson(createInvoiceProposalRequestStub)

        Given {
            headers(header)
            body(body)
        } When {
            post("invoice/proposal")
        } Then {
            statusCode(SC_CREATED)
        }
    }

}