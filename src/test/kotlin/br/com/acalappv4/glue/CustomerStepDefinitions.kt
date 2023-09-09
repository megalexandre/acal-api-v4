package br.com.acalappv4.glue

import br.com.acalappv4.application.web.customer.request.CustomerSaveRequest
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
        membershipNumber: Int,
        active: Boolean
    ) {
        val validCustomer =
            CustomerSaveRequest(
                name = name,
                documentNumber = documentNumber,
                personType = personType,
                birthDay = LocalDate.parse(birthDay),
                membershipNumber = membershipNumber,
                phoneNumbers = null,
                active = active
            )
    }


    @Then("the customer is saved in the database")
    fun verifyCustomerSaved() {
        // Implement the logic to verify if the customer is saved in the database.
        // This may involve a database query or a service call.
    }
}