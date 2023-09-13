package br.com.acalappv4.application.web.address.response

import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.entity.Area
import org.springframework.data.domain.Page

class PageResponseAddress (
    val id: String,
    val area: Area,
    val number: String,
    val letter: String,
    val hasHydrometer: Boolean,
){

    constructor(address: Address) : this(
        id = address.id,
        area = address.area,
        number = address.number,
        letter = address.letter,
        hasHydrometer = address.hasHydrometer,
    )

}

fun Page<Address>.toAddressPageResponse() = map { PageResponseAddress(it) }
