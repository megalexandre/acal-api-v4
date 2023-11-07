package br.com.acalappv4.application.web.hydrometer.request

import br.com.acalappv4.application.web.address.request.AddressRequest
import br.com.acalappv4.domain.entity.Hydrometer
import br.com.acalappv4.domain.entity.HydrometerCollect
import br.com.acalappv4.domain.entity.Reference
import io.azam.ulidj.ULID

data class HydrometerCreateRequest (
    val address: AddressRequest,
    val actualCollect: HydrometerCollectRequest,
    val lastCollect: HydrometerCollectRequest,
){
    fun toHydrometer() = Hydrometer(
        id = ULID.random(),
        address = address.toEntity(),
        reference = actualCollect.reference,
        actualCollect = actualCollect.toEntity(),
        lastCollect = lastCollect.toEntity(),
    )
}

data class HydrometerCollectRequest(
    val reference: Reference,
    val totalMeter: Long,
){
    fun toEntity() = HydrometerCollect(
        reference = reference,
        totalMeter = totalMeter,
    )
}

