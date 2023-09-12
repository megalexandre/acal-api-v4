package br.com.acalappv4.application.web.address.request

import br.com.acalappv4.application.web.adapter.RequestAdapter
import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.entity.Area
import io.azam.ulidj.ULID.random

data class CreateAddressRequest (
    val area: Area,
    val number: String,
    val letter: String,
    val hasHydrometer: Boolean,

): RequestAdapter<Address> {

    override fun toEntity(): Address = Address(
        id = random(),
        area = area,
        number = number.trim(),
        letter = letter.trim(),
        hasHydrometer = hasHydrometer,
    )

}