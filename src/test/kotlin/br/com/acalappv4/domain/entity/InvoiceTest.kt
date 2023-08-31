package br.com.acalappv4.domain.entity

import java.math.BigDecimal
import java.math.BigDecimal.*
import java.time.LocalDateTime.now
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import stub.invoiceDetailStub
import stub.invoiceStub


internal class InvoiceTest{

    @Test
    fun `WHEN all details is paid SHOULD invoice is paid`(){
        val invoiceDetailWithAllDetailPaid: Invoice = invoiceStub.copy(
            invoiceDetails = listOf(invoiceDetailStub.copy(
                dataPaid = now()
            ))
        )

        assertTrue(invoiceDetailWithAllDetailPaid.isPayed)
    }

    @Test
    fun `WHEN at last detail is not paid SHOULD invoice is not paid`(){
        val invoiceDetailWithAllDetailPaid: Invoice = invoiceStub.copy(
            invoiceDetails = listOf(
                invoiceDetailStub.copy(dataPaid = now()),
                invoiceDetailStub.copy(dataPaid = null)
            )
        )

        assertFalse(invoiceDetailWithAllDetailPaid.isPayed)
    }

    @Test
    fun `WHEN invoice has no detail SHOULD invoice is paid`(){
        val invoiceDetailWithoutDetail: Invoice = invoiceStub.copy(
            invoiceDetails = listOf()
        )

        assertTrue(invoiceDetailWithoutDetail.isPayed)
    }

    @Test
    fun `WHEN invoice has many detail SHOULD sum all values to total `(){
        val invoiceDetailWithElevenTotal: Invoice = invoiceStub.copy(
            invoiceDetails = listOf(
                invoiceDetailStub.copy(value = ONE),
                invoiceDetailStub.copy(value = TEN)
            )
        )

        assertEquals(BigDecimal(11), invoiceDetailWithElevenTotal.totalValue)
    }

    @Test
    fun `WHEN invoice has no detail SHOULD sum be zero `(){
        val invoiceDetailWithElevenTotal: Invoice = invoiceStub.copy(
            invoiceDetails = listOf()
        )

        assertEquals(ZERO, invoiceDetailWithElevenTotal.totalValue)
    }

    @Test
    fun `WHEN invoice has many detail SHOULD sum only is not paid `(){
        val invoiceDetailWithManyPaidStates: Invoice = invoiceStub.copy(
            invoiceDetails = listOf(
                invoiceDetailStub.copy(value = ONE, dataPaid = now()),
                invoiceDetailStub.copy(value = TEN, dataPaid = null)
            )
        )

        assertEquals(TEN, invoiceDetailWithManyPaidStates.totalAwaitingPayment)
    }

    @Test
    fun `WHEN invoice has many detail awaiting payment SHOULD sum them`(){
        val invoiceDetailWithManyPaidStates: Invoice = invoiceStub.copy(
            invoiceDetails = listOf(
                invoiceDetailStub.copy(value = ONE, dataPaid = now()),
                invoiceDetailStub.copy(value = TEN, dataPaid = null)
            )
        )

        assertEquals(ONE, invoiceDetailWithManyPaidStates.totalPaidValue)
    }


}