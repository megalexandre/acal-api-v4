package br.com.acalappv4.application.web.address.response

import br.com.acalappv4.application.web.adapter.ResponseAdapter
import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.entity.Area

data class AddressResponse (
    val id: String,
    val area: Area,
    val number: String,
    val letter: String,
    val hasHydrometer: Boolean,

): ResponseAdapter<Address, AddressResponse> {

    constructor(address: Address) : this(
        id = address.id,
        area = address.area,
        number = address.number,
        letter = address.letter,
        hasHydrometer = address.hasHydrometer,
    )

    override fun toResponse(entity: Address): AddressResponse =  AddressResponse(entity)
}



