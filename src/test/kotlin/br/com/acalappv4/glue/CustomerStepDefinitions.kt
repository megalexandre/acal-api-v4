package br.com.acalappv4.glue

import br.com.acalappv4.application.web.customer.request.CustomerCreateRequest
import br.com.acalappv4.common.enums.PersonType
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import java.time.LocalDate

class CustomerStepDefinitions {

    @Given("a new customer with the following data:")
    fun createNewCustomer(
        name: String,
        documentNumber: String,
        personType: PersonType,
        birthDay: String,
        membershipNumber: String,
        active: Boolean
    ) {
        val validCustomer =
            CustomerCreateRequest(
                name = name,
                documentNumber = documentNumber,
                birthDay = LocalDate.parse(birthDay),
                membershipNumber = membershipNumber,
                phoneNumbers = null,
            )
    }


    @Then("the customer is saved in the database")
    fun verifyCustomerSaved() {
        // Implement the logic to verify if the customer is saved in the database.
        // This may involve a database query or a service call.
    }
}