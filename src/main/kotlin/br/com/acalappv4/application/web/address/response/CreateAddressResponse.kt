package br.com.acalappv4.application.web.address.response

import br.com.acalappv4.application.web.adapter.ResponseAdapter
import br.com.acalappv4.domain.entity.Address

data class CreateAddressResponse (
    val id: String,
): ResponseAdapter<Address, CreateAddressResponse> {

    constructor(address: Address) : this(
        id = address.id,
    )

    override fun toResponse(entity: Address): CreateAddressResponse =  CreateAddressResponse(entity)
}



