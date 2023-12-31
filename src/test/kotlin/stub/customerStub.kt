package stub

import br.com.acalappv4.common.enums.PersonType.INDIVIDUAL
import br.com.acalappv4.domain.entity.Customer

val customerStub = Customer(
    id = "1",
    name = "Alexandre Queiroz",
    documentNumber = documentNumberStub,
    personType = INDIVIDUAL,
    birthDay = null,
    membershipNumber = "0",
    phoneNumbers = listOf(phoneNumberStub),
    active = true,
)
