package br.com.acalappv4.application.web.area.request

import br.com.acalappv4.application.web.adapter.RequestAdapter
import br.com.acalappv4.domain.entity.Area
import io.azam.ulidj.ULID.random

data class CreateAreaRequest (
    val name: String,
): RequestAdapter<Area> {

    override fun toEntity(): Area = Area(
        id = random(),
        name = name.trim(),
    )

}