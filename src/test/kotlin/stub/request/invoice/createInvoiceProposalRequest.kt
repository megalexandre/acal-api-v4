package stub.request.invoice

import java.time.LocalDateTime.now

val createInvoiceRequestStub = CreateInvoiceRequest(
    reference = "112023",
    dueDate = now().plusMonths(1)
)
