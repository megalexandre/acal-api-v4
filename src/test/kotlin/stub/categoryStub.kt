package stub

import br.com.acalappv4.common.enums.CategoryType.EFFECTIVE
import br.com.acalappv4.domain.entity.Category
import java.math.BigDecimal.ZERO

val categoryStub = Category(
    id = "1",
    name = "Usúario",
    waterValue = ZERO,
    categoryValue = ZERO,
    type = EFFECTIVE
)
