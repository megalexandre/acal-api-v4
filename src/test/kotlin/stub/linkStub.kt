package stub

import br.com.acalappv4.common.Category.EFFECTIVE
import br.com.acalappv4.domain.entity.Link
import java.time.LocalDateTime.now

val linkStub = Link(
    id = "1",
    active = true,
    createdAt = now(),
    updatedAt = now(),
    category = EFFECTIVE,
    invoices = listOf(invoiceStub),
)
