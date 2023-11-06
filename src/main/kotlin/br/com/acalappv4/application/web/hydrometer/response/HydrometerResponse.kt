package br.com.acalappv4.application.web.hydrometer.response

import br.com.acalappv4.application.web.address.response.AddressResponse
import br.com.acalappv4.domain.entity.Hydrometer
import br.com.acalappv4.domain.entity.HydrometerCollect
import br.com.acalappv4.domain.entity.Reference
import java.math.BigDecimal

data class HydrometerResponse (
    val id: String,
    val address: AddressResponse,
    val actualCollect: HydrometerCollectResponse,
    val lastCollect: HydrometerCollectResponse,
    val reference: Reference,
    val consumption: Long,
    val consideredConsumption: Long,
    val value: BigDecimal,
){
    constructor(hydrometer: Hydrometer) : this(
        id = hydrometer.id,
        address = AddressResponse(hydrometer.address),
        actualCollect = HydrometerCollectResponse(hydrometer.actualCollect),
        lastCollect = HydrometerCollectResponse(hydrometer.lastCollect),
        reference = hydrometer.reference,
        consumption = hydrometer.consumption,
        consideredConsumption = hydrometer.consideredConsumption,
        value = hydrometer.value
    )
}

data class HydrometerCollectResponse(
    val reference: Reference,
    val totalMeter: Long,
) {
    constructor(hydrometerCollect: HydrometerCollect): this(
        reference = hydrometerCollect.reference,
        totalMeter = hydrometerCollect.totalMeter
    )
}
