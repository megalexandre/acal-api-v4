package br.com.acalappv4.application.web.area.response

import br.com.acalappv4.application.web.components.adapter.ResponseAdapter
import br.com.acalappv4.application.web.address.response.AddressResponse
import br.com.acalappv4.domain.entity.Address
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

fun List<Area>.toAreaResponse() = map { AreaResponse(it) }