package br.com.acalappv4.domain.entity

import java.time.LocalDateTime.now
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import stub.invoiceDetailStub

internal class InvoiceDetailTest{

    @Test
    fun `WHEN invoice detail has a data paid SHOULD is paid`(){
        val invoiceDetailWithDataPaid: InvoiceDetail = invoiceDetailStub.copy(dataPaid = now())
        assertTrue(invoiceDetailWithDataPaid.isPaid)
    }

    @Test
    fun `WHEN invoice detail has a data paid null SHOULD is not paid`(){
        val invoiceDetailWithoutDataPaid: InvoiceDetail = invoiceDetailStub.copy(dataPaid = null)
        assertFalse(invoiceDetailWithoutDataPaid.isPaid)
    }

    @Test
    fun `WHEN invoice detail is Paid  SHOULD is not paid`(){
        val invoiceDetailWithDataPaid: InvoiceDetail = invoiceDetailStub.copy(dataPaid = null)
        assertTrue(invoiceDetailWithDataPaid.isNotPaid)
    }


}