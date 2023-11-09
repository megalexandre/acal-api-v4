package br.com.acalappv4.domain.entity

import br.com.acalappv4.domain.entity.interfaces.Entity
import br.com.acalappv4.util.toCurrency
import java.math.BigDecimal

data class Hydrometer(

    val id: String,
    val address: Address,
    val reference: Reference,
    val actualCollect: HydrometerCollect,
    val lastCollect: HydrometerCollect,

    val waterPrice: BigDecimal = BigDecimal(WATER_PRICE),
    val waterFreeTier: Long = WATER_FREE_TIER,

    ): Entity {
    companion object{
        private const val WATER_PRICE = "0.004"
        private const val WATER_FREE_TIER = 10000L
    }

    val consumption: Long = actualCollect.totalMeter - lastCollect.totalMeter

    val consideredConsumption: Long = when(consumption <= waterFreeTier){
        true -> 0
        false -> consumption - waterFreeTier
    }

    val value: BigDecimal = BigDecimal(consideredConsumption).multiply(waterPrice).toCurrency()
}

data class HydrometerCollect(
    val reference: Reference,
    val totalMeter: Long,
)
