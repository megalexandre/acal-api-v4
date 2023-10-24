package br.com.acalappv4.application.web.area.request

import br.com.acalappv4.domain.dto.list.AreaFilter

class AreaFilterRequest (
    val id: String? = null,
    val name: String? = null,
){
    fun toAreaFilter(): AreaFilter = AreaFilter(
        id = id,
        name = name
    )
}