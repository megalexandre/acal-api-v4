package br.com.acalappv4.application.web.address.response

import br.com.acalappv4.application.web.components.adapter.ResponseAdapter
import br.com.acalappv4.domain.entity.Address

data class AddressCreateResponse (
    val id: String,
): ResponseAdapter<Address, AddressCreateResponse> {

    constructor(address: Address) : this(
        id = address.id,
    )

    override fun toResponse(entity: Address): AddressCreateResponse =  AddressCreateResponse(entity)
}



