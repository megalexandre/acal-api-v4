package stub

import br.com.acalappv4.domain.entity.Reference
import java.time.LocalDateTime.now
import java.time.Month
import java.time.Year

val referenceStub = Reference(
   year = Year.from(now()),
    month = Month.from(now()),
)