package br.com.acalappv4.application.web.category.request

import br.com.acalappv4.common.enums.CategoryType
import br.com.acalappv4.domain.dto.PageFilterCategory
import br.com.acalappv4.domain.dto.Page
import br.com.acalappv4.domain.dto.Sort
import java.math.BigDecimal

class CategoryPageFilterRequest(
    val id: String?,
    val name: String?,
    val value: BigDecimal?,
    val categoryType: CategoryType?,
    val page: Page?,
    val sort: Sort?,
){

    fun toEntity(): PageFilterCategory = PageFilterCategory(
        id = id,
        name = name,
        value = value,
        categoryType = categoryType,
        page = page,
        sort = sort,
    )


}