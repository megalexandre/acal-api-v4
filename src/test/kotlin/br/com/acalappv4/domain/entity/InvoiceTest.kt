package br.com.acalappv4.domain.entity

import java.math.BigDecimal
import java.math.BigDecimal.TEN
import java.math.BigDecimal.ZERO
import java.time.LocalDateTime.now
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import stub.invoiceDetailStub
import stub.invoiceStub

internal class InvoiceTest{

    @Test
    fun `WHEN all details is payed SHOULD is payed`(){
        val invoice: Invoice = invoiceStub.copy(
            invoiceDetails = listOf(
                invoiceDetailStub.copy(dataPayed = now()),
                invoiceDetailStub.copy(dataPayed = now()),
            )
        )

        assertTrue(invoice.isPayed)
    }

    @Test
    fun `WHEN at least a details is not payed SHOULD is not payed`(){
        val invoice: Invoice = invoiceStub.copy(
            invoiceDetails = listOf(
                invoiceDetailStub.copy(dataPayed = now()),
                invoiceDetailStub.copy(dataPayed = null),
            )
        )

        assertFalse(invoice.isPayed)
    }

    @Test
    fun `WHEN a invoice has many details SHOULD sum values`(){
        val invoice: Invoice = invoiceStub.copy(
            invoiceDetails = listOf(
                invoiceDetailStub.copy(value = TEN),
                invoiceDetailStub.copy(value = BigDecimal(45)),
            )
        )

        assertEquals(BigDecimal(55), invoice.totalValue)
    }

    @Test
    fun `WHEN a invoice has details not payed SHOULD sum only payed values`(){
        val invoice: Invoice = invoiceStub.copy(
            invoiceDetails = listOf(
                invoiceDetailStub.copy(dataPayed = now(), value = TEN),
                invoiceDetailStub.copy(dataPayed = null,  value = BigDecimal(45)),
            )
        )

        assertEquals(BigDecimal(10), invoice.payedValue)
    }

    @Test
    fun `WHEN a invoice has details not payed SHOULD sum only awaiting payment values`(){
        val invoice: Invoice = invoiceStub.copy(
            invoiceDetails = listOf(
                invoiceDetailStub.copy(dataPayed = now(), value = TEN),
                invoiceDetailStub.copy(dataPayed = null,  value = BigDecimal(45)),
            )
        )

        assertEquals(BigDecimal(45), invoice.awaitingPaymentValue)
    }


    @Test
    fun `WHEN due date is over now and data payed is null SHOULD is over due`(){
        val invoice: Invoice = invoiceStub.copy(
            dueDate = now().minusDays(1),
            invoiceDetails = listOf(
                invoiceDetailStub.copy(
                    dataPayed = null
                ),
                invoiceDetailStub
            )
        )

        assertTrue(invoice.isOverDue)
    }

    @Test
    fun `WHEN has empty detail list SHOULD total be zero`(){
        val invoice: Invoice = invoiceStub.copy(
            invoiceDetails = emptyList()
        )

        assertEquals(ZERO, invoice.totalValue)
    }

    @Test
    fun `WHEN a invoice is over due SHOULD return a count of days`(){
        val invoice: Invoice = invoiceStub.copy(
            dueDate = now().minusDays(30)
        )

        assertEquals(30, invoice.overDueDays)
    }




}