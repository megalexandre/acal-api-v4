package br.com.acalappv4.application.web.category.response

import br.com.acalappv4.common.enums.CategoryType
import br.com.acalappv4.domain.entity.Category
import java.math.BigDecimal
import org.springframework.data.domain.Page

class CategoryPageResponse (
    val id: String,
    val name: String,
    val value: BigDecimal,
    val type: CategoryType,
){

    constructor(category: Category) : this(
        id = category.id,
        name = category.name,
        value = category.value,
        type = category.type
    )

}

fun Page<Category>.toCategoryPageResponse() = map { CategoryPageResponse(it) }
