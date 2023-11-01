package br.com.acalappv4.domain.entity

import br.com.acalappv4.util.toCurrency
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import stub.hydrometerCollectStub
import stub.hydrometerStub
import java.math.BigDecimal

class HydrometerTest{

    @Test
    fun `when a difference between gathering is positive should calculate quantity`(){

        val hydrometer = hydrometerStub.copy(
            actualCollect = hydrometerCollectStub.copy(
                reference = Reference.getCurrent(),
                totalMeter = 15000
            ),
            lastCollect = hydrometerCollectStub.copy(
                reference = Reference.getCurrent(),
                totalMeter = 26000
            ),
        )

        assertEquals(11000, hydrometer.consumption)
        assertEquals(1000, hydrometer.consideredConsumption)
    }

    @Test
    fun `when a difference between gathering is less or equal should calculate quantity as zero`(){

        val hydrometer = hydrometerStub.copy(
            actualCollect = hydrometerCollectStub.copy(
                reference = Reference.getCurrent(),
                totalMeter = 15000
            ),
            lastCollect = hydrometerCollectStub.copy(
                reference = Reference.getCurrent(),
                totalMeter = 25000
            ),
        )

        assertEquals(10000, hydrometer.consumption)
        assertEquals(0, hydrometer.consideredConsumption)
    }

    @Test
    fun `when a difference between gathering is positive should calculate price`(){

        val hydrometer = hydrometerStub.copy(
            actualCollect = hydrometerCollectStub.copy(
                reference = Reference.getCurrent(),
                totalMeter = 15000
            ),
            lastCollect = hydrometerCollectStub.copy(
                reference = Reference.getCurrent(),
                totalMeter = 26000
            ),
        )

        assertEquals(BigDecimal(4).toCurrency(), hydrometer.value)
    }


    @Test
    fun `when a difference between gathering is lest or equal then free tier should calculate as zero`(){

        val hydrometer = hydrometerStub.copy(
            actualCollect = hydrometerCollectStub.copy(
                reference = Reference.getCurrent(),
                totalMeter = 15000
            ),
            lastCollect = hydrometerCollectStub.copy(
                reference = Reference.getCurrent(),
                totalMeter = 25000
            ),
        )

        assertEquals(BigDecimal(0).toCurrency(), hydrometer.value)
    }

}