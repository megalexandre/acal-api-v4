package br.com.acalappv4.domain.entity

import java.time.LocalDateTime.now
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import stub.invoiceDetailStub

internal class InvoiceDetailTest{

    @Test
    fun `WHEN data payed is not null SHOULD is payed`(){
        val detail = invoiceDetailStub.copy(dataPayed = now())

        assertTrue(detail.isPayed, )
        assertFalse(detail.isAwaitingPayment, )
    }

    @Test
    fun `WHEN data payed is null SHOULD is not payed`(){
        val detail = invoiceDetailStub.copy(dataPayed = null)

        assertFalse(detail.isPayed)
        assertTrue(detail.isAwaitingPayment)
    }

}