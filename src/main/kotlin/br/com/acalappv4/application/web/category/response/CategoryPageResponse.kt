package br.com.acalappv4.application.web.category.response

import br.com.acalappv4.common.enums.CategoryType
import br.com.acalappv4.domain.entity.Category
import java.math.BigDecimal
import org.springframework.data.domain.Page
import java.time.LocalDateTime

class CategoryPageResponse (
    val id: String,
    val name: String,
    val categoryValue: BigDecimal,
    val waterValue: BigDecimal,
    val type: CategoryType,
    val total: BigDecimal,
){

    constructor(category: Category) : this(
        id = category.id,
        name = category.name,
        categoryValue = category.categoryValue,
        waterValue = category.waterValue,
        type = category.type,
        total = category.categoryValue + category.waterValue,
    )

}

fun Page<Category>.toCategoryPageResponse() = map { CategoryPageResponse(it) }
