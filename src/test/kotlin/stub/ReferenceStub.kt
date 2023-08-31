package stub

import br.com.acalappv4.domain.entity.Reference
import java.time.LocalDateTime.now

val reference = Reference(
   year = now().year.toString(),
    month = now().monthValue.toString(),
)