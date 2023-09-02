package stub

import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.entity.Area
import br.com.acalappv4.domain.entity.Invoice
import java.math.BigDecimal.ONE
import java.time.LocalDateTime.now

val addressStub = Address(
    id = "1",
    area = areaStub,
    number = 1,
    letter = "a",
    hasHydrometer = true,
)
