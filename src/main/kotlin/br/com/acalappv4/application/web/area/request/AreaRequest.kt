package br.com.acalappv4.application.web.area.request

import br.com.acalappv4.application.web.components.adapter.RequestAdapter
import br.com.acalappv4.domain.entity.Area

data class AreaRequest (
    val id: String,
    val name: String,
): RequestAdapter<Area> {

    override fun toEntity(): Area = Area(
        id = id,
        name = name.trim(),
    )

}