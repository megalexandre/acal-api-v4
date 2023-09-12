package br.com.acalappv4.application.web.category.request

import br.com.acalappv4.application.adapter.RequestAdapter
import br.com.acalappv4.common.enums.CategoryType
import br.com.acalappv4.domain.entity.Category
import java.math.BigDecimal

data class UpdateCategoryRequest (
    val id: String,
    val name: String,
    val value: BigDecimal,
    val type: CategoryType,
): RequestAdapter<Category> {

    override fun toEntity(): Category = Category(
        id = id,
        name = name.trim(),
        value = value,
        type = type,
    )

}