package br.com.acalappv4.application.web.category.response

import br.com.acalappv4.application.web.adapter.ResponseAdapter
import br.com.acalappv4.domain.entity.Category

data class CreateCategoryResponse (
    val id: String,
): ResponseAdapter<Category, CreateCategoryResponse> {

    constructor(category: Category) : this(
        id = category.id,
    )

    override fun toResponse(entity: Category): CreateCategoryResponse =  CreateCategoryResponse(entity)
}



