package br.com.acalappv4.domain.dto

import br.com.acalappv4.common.enums.CategoryType
import br.com.acalappv4.domain.dto.Page
import br.com.acalappv4.domain.dto.Sort
import java.math.BigDecimal

class CategoryPageFilter(
    val id: String?,
    val name: String?,
    val value: BigDecimal?,
    val categoryType: CategoryType?,
    val page: Page?,
    val sort: Sort?,
)