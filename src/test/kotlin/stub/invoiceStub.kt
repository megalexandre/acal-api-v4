package stub

import br.com.acalappv4.domain.entity.Invoice
import br.com.acalappv4.domain.entity.LinkDetail
import java.time.LocalDateTime.now

val linkDetailStub = LinkDetail(
    linkId = "i",
    customer = "any",
    address = "address"
)

val invoiceStub = Invoice(
    id = "1",
    reference = reference,
    emission = now(),
    dueDate = now().plusMonths(1),
    linkDetail = linkDetailStub,
    invoiceDetails = listOf(invoiceDetailStub)
)
