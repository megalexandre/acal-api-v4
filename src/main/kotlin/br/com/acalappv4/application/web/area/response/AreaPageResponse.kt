package br.com.acalappv4.application.web.area.response

import br.com.acalappv4.domain.entity.Area
import org.springframework.data.domain.Page

class PageResponseArea (
    val id: String,
    val name: String,
){

    constructor(area: Area) : this(
        id = area.id,
        name = area.name,
    )

}

fun Page<Area>.toAreaPageResponse() = map { PageResponseArea(it) }
