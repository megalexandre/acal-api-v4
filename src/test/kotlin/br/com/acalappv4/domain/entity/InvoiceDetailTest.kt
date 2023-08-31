package br.com.acalappv4.domain.entity

import java.time.LocalDateTime.now
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import stub.invoiceDetailStub

internal class InvoiceDetailTest{

    @Test
    fun `WHEN invoice detail has a data paid SHOULD is paid`(){
        val invoiceDetailWithDataPaid: InvoiceDetail = invoiceDetailStub.copy(dataPaid = now())
        assertTrue(invoiceDetailWithDataPaid.isPaid)
    }
}