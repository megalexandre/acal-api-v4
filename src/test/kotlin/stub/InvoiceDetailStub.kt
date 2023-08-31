package stub

import br.com.acalappv4.common.enums.Reason.INVOICE
import br.com.acalappv4.domain.entity.InvoiceDetail
import java.math.BigDecimal.ONE
import java.time.LocalDateTime.now

val invoiceDetailStub = InvoiceDetail(
    id = "1",
    reason = INVOICE,
    value = ONE,
    dataPaid = now()
)