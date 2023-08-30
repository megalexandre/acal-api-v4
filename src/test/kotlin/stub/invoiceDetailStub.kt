package stub

import br.com.acalappv4.domain.entity.InvoiceDetail
import java.math.BigDecimal.TEN
import java.time.LocalDateTime.now

val invoiceDetailStub = InvoiceDetail(
    id = "1",
    value = TEN,
    dataPayed = now(),
)
