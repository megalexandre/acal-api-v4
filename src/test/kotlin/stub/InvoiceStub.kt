package stub

import br.com.acalappv4.domain.entity.Invoice
import java.math.BigDecimal.ONE
import java.time.LocalDateTime.now

val invoiceStub = Invoice(
    reference = reference,
    emission = now(),
    dueDate = now().plusMonths(1),
    invoiceDetails = listOf(invoiceDetailStub)
)