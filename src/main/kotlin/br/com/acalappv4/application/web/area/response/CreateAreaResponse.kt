package br.com.acalappv4.application.web.area.response

import br.com.acalappv4.application.web.components.adapter.ResponseAdapter
import br.com.acalappv4.domain.entity.Area

data class CreateAreaResponse (
    val id: String,
): ResponseAdapter<Area, CreateAreaResponse> {

    constructor(area: Area) : this(
        id = area.id,
    )

    override fun toResponse(entity: Area): CreateAreaResponse =  CreateAreaResponse(entity)
}



