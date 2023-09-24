package stub.request

import br.com.acalappv4.application.web.customer.request.CustomerCreateRequest
import br.com.acalappv4.common.enums.PersonType.INDIVIDUAL
import stub.documentNumberStub

val createCustomerRequestStub = CustomerCreateRequest(
    name = "Alexandre Queiroz",
    documentNumber = documentNumberStub.number,
    personType = INDIVIDUAL,
    birthDay = null,
    membershipNumber = "0",
    phoneNumbers = listOf(phoneNumberSaveRequestStub),
)



