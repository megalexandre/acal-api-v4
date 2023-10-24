package br.com.acalappv4.application.web.category.request

import br.com.acalappv4.common.enums.CategoryType
import br.com.acalappv4.domain.dto.list.CategoryFilter
import java.math.BigDecimal

data class CategoryFilterRequest(
    val id: String? = null,
    val name: String? = null,
    val waterValue: BigDecimal? = null,
    val categoryValue: BigDecimal? = null,
    val totalValue: BigDecimal? = null,
    val categoryType: CategoryType? = null,
){
    fun toCategoryFilter(): CategoryFilter = CategoryFilter(
        id = id,
        name = name,
        waterValue = waterValue,
        categoryValue = categoryValue,
        totalValue = totalValue,
        categoryType = categoryType,
    )
}