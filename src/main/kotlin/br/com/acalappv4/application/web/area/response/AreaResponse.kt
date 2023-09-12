package br.com.acalappv4.application.web.area.response

import br.com.acalappv4.application.web.adapter.ResponseAdapter
import br.com.acalappv4.domain.entity.Area

data class AreaResponse (
    val id: String,
    val name: String,
): ResponseAdapter<Area, AreaResponse> {

   constructor(area: Area) : this(
       id = area.id,
       name = area.name,
   )

   override fun toResponse(entity: Area): AreaResponse =  AreaResponse(entity)

}

