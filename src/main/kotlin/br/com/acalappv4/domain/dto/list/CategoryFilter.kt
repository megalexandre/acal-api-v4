package br.com.acalappv4.domain.dto.list

import br.com.acalappv4.common.enums.CategoryType
import java.math.BigDecimal

class CategoryFilter(
    val id: String? = null,
    val name: String? = null,
    val waterValue: BigDecimal? = null,
    val categoryValue: BigDecimal? = null,
    val totalValue: BigDecimal? = null,
    val categoryType: CategoryType? = null,
): DefaultFilter