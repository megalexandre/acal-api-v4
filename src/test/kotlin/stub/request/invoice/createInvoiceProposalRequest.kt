package stub.request.invoice

import br.com.acalappv4.application.web.invoice.request.InvoiceCreateRequest
import br.com.acalappv4.application.web.invoice.request.InvoiceNumberRequest
import br.com.acalappv4.common.enums.Reason
import br.com.acalappv4.domain.entity.InvoiceDetail
import br.com.acalappv4.domain.entity.LinkDetail
import br.com.acalappv4.domain.entity.Reference
import java.math.BigDecimal
import java.time.LocalDateTime.now
import java.time.Month.DECEMBER
import java.time.Month.JANUARY
import java.time.Year

val invoiceNumberRequestStub = InvoiceNumberRequest(
    year = Year.of(2023),
    month = JANUARY,
    number = "000001"
)

val invoiceCreateRequestStub = InvoiceCreateRequest(
    reference = Reference(year = Year.now(), month = DECEMBER),
    dueDate = now().plusMonths(1),
    emission = now(),
    linkDetail = LinkDetail(
        linkId = "link",
        customer =  "customer",
        address = "address",
    ),
    number = invoiceNumberRequestStub,
    invoiceDetails = listOf(InvoiceDetail(
        reason = Reason.INVOICE,
        value = BigDecimal.ONE,
        dataPaid = now()
        ),
    ),
)

