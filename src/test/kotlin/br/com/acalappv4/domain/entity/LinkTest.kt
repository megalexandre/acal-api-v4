package br.com.acalappv4.domain.entity

import java.time.LocalDateTime
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import stub.invoiceDetailStub
import stub.invoiceStub
import stub.linkStub

internal class LinkTest{

    @Test
    fun `WHEN link has no one link SHOULD be due date false`(){
        val linkWithEmptyInvoices: Link = linkStub.copy(
            invoices = emptyList()
        )

        assertFalse(linkWithEmptyInvoices.isOverDue)
    }

    @Test
    fun `WHEN link has no one link SHOULD be due cancellation risk false`(){
        val linkWithEmptyInvoices: Link = linkStub.copy(
            invoices = emptyList()
        )

        assertFalse(linkWithEmptyInvoices.cancellationOfRisk)
    }

    @Test
    fun `WHEN link has at least a invoice with 60 days over due SHOULD be due cancellation risk`(){
        val linkWithEmptyInvoices: Link = linkStub.copy(
            invoices = listOf(invoiceStub.copy(
                dueDate = LocalDateTime.now().minusDays(60),
                invoiceDetails = listOf(invoiceDetailStub.copy(
                    dataPaid = null
                ))
            ))
        )

        assertTrue(linkWithEmptyInvoices.cancellationOfRisk)
    }

    @Test
    fun `WHEN link has at least a invoice with 1 days over due SHOULD over due`(){
        val linkWithEmptyInvoices: Link = linkStub.copy(
            invoices = listOf(invoiceStub.copy(
                dueDate = LocalDateTime.now().minusDays(1),
                invoiceDetails = listOf(invoiceDetailStub.copy(
                    dataPaid = null
                ))
            ))
        )

        assertTrue(linkWithEmptyInvoices.isOverDue)
    }


}