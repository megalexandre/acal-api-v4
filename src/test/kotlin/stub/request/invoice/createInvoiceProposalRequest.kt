package stub.request.invoice

import br.com.acalappv4.application.web.invoice.request.CreateInvoiceProposalRequest
import java.time.LocalDateTime.now

val createInvoiceProposalRequestStub = CreateInvoiceProposalRequest(
    reference = "112023",
    dueDate = now().plusMonths(1)
)
