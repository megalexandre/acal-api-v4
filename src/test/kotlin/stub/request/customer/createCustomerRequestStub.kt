package stub.request.customer

import br.com.acalappv4.application.web.customer.request.CustomerCreateRequest
import stub.documentNumberStub

val createCustomerRequestStub = CustomerCreateRequest(
    name = "Alexandre Queiroz",
    documentNumber = documentNumberStub.number,
    birthDay = null,
    membershipNumber = "0",
    phoneNumbers = listOf(phoneNumberSaveRequestStub),
)



