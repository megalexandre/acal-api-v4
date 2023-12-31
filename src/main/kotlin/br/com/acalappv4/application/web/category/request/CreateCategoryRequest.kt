package br.com.acalappv4.application.web.category.request

import br.com.acalappv4.application.web.components.adapter.RequestAdapter
import br.com.acalappv4.common.enums.CategoryType
import br.com.acalappv4.domain.entity.Category
import io.azam.ulidj.ULID.random
import java.math.BigDecimal

data class CreateCategoryRequest (
    val name: String,
    val waterValue: BigDecimal,
    val categoryValue: BigDecimal,
    val type: CategoryType,
): RequestAdapter<Category> {

    override fun toEntity(): Category = Category(
        id = random(),
        name = name.trim(),
        waterValue = waterValue,
        categoryValue = categoryValue,
        type = type,
    )

}