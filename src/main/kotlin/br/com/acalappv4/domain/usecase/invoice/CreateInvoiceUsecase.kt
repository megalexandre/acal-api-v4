package br.com.acalappv4.domain.usecase.invoice

import br.com.acalappv4.domain.datasource.InvoiceDataSource
import br.com.acalappv4.domain.entity.Invoice
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateInvoiceUsecase(
    private val invoiceDataSource: InvoiceDataSource,
): Usecase<List<Invoice>, List<Invoice>> {

    @Transactional
    override fun execute(input: List<Invoice>): List<Invoice> {
        input.forEach {  invoiceDataSource.save(invoice = it) }
        return input
    }

}