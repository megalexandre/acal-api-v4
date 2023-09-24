package br.com.acalappv4.application.web.category.response

import br.com.acalappv4.application.web.adapter.ResponseAdapter
import br.com.acalappv4.common.enums.CategoryType
import br.com.acalappv4.domain.entity.Category
import java.math.BigDecimal

data class CategoryResponse (
    val id: String,
    val name: String,
    val categoryValue: BigDecimal,
    val waterValue: BigDecimal,
    val type: CategoryType,
): ResponseAdapter<Category, CategoryResponse> {

   constructor(category: Category) : this(
       id = category.id,
       name = category.name,
       categoryValue = category.categoryValue,
       waterValue = category.waterValue,
       type = category.type,
   )

   override fun toResponse(entity: Category): CategoryResponse =  CategoryResponse(entity)

}

