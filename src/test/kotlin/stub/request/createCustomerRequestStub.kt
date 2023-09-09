package stub.request

import br.com.acalappv4.application.web.customer.request.CustomerSaveRequest
import br.com.acalappv4.common.enums.PersonType.INDIVIDUAL
import stub.documentNumberStub

val createCustomerRequestStub = CustomerSaveRequest(
    name = "Alexandre Queiroz",
    documentNumber = documentNumberStub.number,
    personType = INDIVIDUAL,
    birthDay = null,
    membershipNumber = 0,
    phoneNumbers = listOf(phoneNumberSaveRequestStub),
    active = true,
)



