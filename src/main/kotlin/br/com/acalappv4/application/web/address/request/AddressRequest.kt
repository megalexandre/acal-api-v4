package br.com.acalappv4.application.web.address.request

import br.com.acalappv4.application.web.area.request.AreaRequest
import br.com.acalappv4.application.web.components.adapter.RequestAdapter
import br.com.acalappv4.domain.entity.Address

data class AddressRequest (

    val id: String,
    val area: AreaRequest,
    val number: String,
    val letter: String,
    val hasHydrometer: Boolean,
): RequestAdapter<Address> {

    override fun toEntity(): Address = Address(
        id = id,
        area = area.toEntity(),
        number = number.trim(),
        letter = letter.trim(),
        hasHydrometer = hasHydrometer,
    )

}