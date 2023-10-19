package br.com.acalappv4.application.web.category.request

import br.com.acalappv4.common.enums.CategoryType
import br.com.acalappv4.domain.dto.list.CategoryFilter
import br.com.acalappv4.domain.dto.page.CategoryPageFilter
import br.com.acalappv4.domain.dto.page.Page
import br.com.acalappv4.domain.dto.page.Sort
import java.math.BigDecimal

class CategoryPageFilterRequest(
    val id: String?,
    val name: String?,
    val categoryValue: BigDecimal?,
    val waterValue: BigDecimal?,
    val totalValue: BigDecimal?,
    val type: CategoryType?,
    val page: Page?,
    val sort: Sort?,
){

    fun toEntity(): CategoryPageFilter = CategoryPageFilter(
        filter = CategoryFilter(
            id = id,
            name = name,
            categoryValue = categoryValue,
            waterValue = waterValue,
            categoryType = type,
            totalValue = totalValue,
        ),
        page = page,
        sort = sort,
    )

}