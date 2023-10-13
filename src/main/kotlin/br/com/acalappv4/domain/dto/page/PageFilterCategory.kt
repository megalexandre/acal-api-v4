package br.com.acalappv4.domain.dto.page

import br.com.acalappv4.common.enums.CategoryType
import java.math.BigDecimal

class PageFilterCategory(
    val id: String?,
    val name: String?,
    val waterValue: BigDecimal?,
    val categoryValue: BigDecimal?,
    val totalValue: BigDecimal?,
    val categoryType: CategoryType?,
    val page: Page?,
    val sort: Sort?,
)