package stub

import br.com.acalappv4.domain.entity.Link
import java.time.LocalDateTime.now

val linkStub = Link(
    id = "1",
    customer = customerStub,
    active = true,
    startedAt = now(),
    finishedAt = now(),
    createdBy = "createdBy",

    address = addressStub,
    addressMail = addressStub,
    category = categoryStub,
    invoices = listOf(invoiceStub),
)
