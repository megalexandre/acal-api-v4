package br.com.acalappv4.application.web.area.response

import br.com.acalappv4.application.web.components.adapter.ResponseAdapter
import br.com.acalappv4.domain.entity.Area

data class AreaCreateResponse (
    val id: String,
): ResponseAdapter<Area, AreaCreateResponse> {

    constructor(area: Area) : this(
        id = area.id,
    )

    override fun toResponse(entity: Area): AreaCreateResponse =  AreaCreateResponse(entity)
}



