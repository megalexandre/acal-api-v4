package stub

import br.com.acalappv4.domain.entity.Invoice
import br.com.acalappv4.domain.entity.InvoiceNumber
import br.com.acalappv4.domain.entity.LinkDetail
import java.time.LocalDateTime.now
import java.time.Month
import java.time.Month.JANUARY
import java.time.Year


val invoiceNumberStub = InvoiceNumber(
    year = Year.of(2023),
    month = JANUARY,
    number = "0000001",
)

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
    invoiceNumber = invoiceNumberStub,
    invoiceDetails = listOf(invoiceDetailStub)
)
