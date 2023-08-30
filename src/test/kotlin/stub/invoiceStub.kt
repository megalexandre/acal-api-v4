package stub

import br.com.acalappv4.domain.entity.Invoice
import br.com.acalappv4.util.toReference
import java.time.LocalDate
import java.time.LocalDateTime.now

val invoiceStub = Invoice(
    id = "1",
    active = true,
    createdAt = now(),
    updatedAt = now(),
    reference = LocalDate.now().toReference(),
    emission = now(),
    dueDate = now().plusMonths(1),
    invoiceDetails = listOf(invoiceDetailStub),
)
