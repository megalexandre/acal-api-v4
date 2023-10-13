package br.com.acalappv4.application.web.address.request

import br.com.acalappv4.application.web.components.adapter.RequestAdapter
import br.com.acalappv4.application.web.area.request.UpdateAreaRequest
import br.com.acalappv4.domain.entity.Address
import io.azam.ulidj.ULID.random

data class CreateAddressRequest (
    val area: UpdateAreaRequest,
    val number: String,
    val letter: String,
    val hasHydrometer: Boolean,

    ): RequestAdapter<Address> {

    override fun toEntity(): Address = Address(
        id = random(),
        area = area.toEntity(),
        number = number.trim(),
        letter = letter.trim(),
        hasHydrometer = hasHydrometer,
    )

}