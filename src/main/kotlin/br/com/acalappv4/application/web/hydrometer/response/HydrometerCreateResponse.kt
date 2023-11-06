package br.com.acalappv4.application.web.hydrometer.response

import br.com.acalappv4.domain.entity.Hydrometer

data class HydrometerCreateResponse (
    val id: String,
){
    constructor(hydrometer: Hydrometer) : this(
        id = hydrometer.id
    )
}

