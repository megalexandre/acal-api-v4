package br.com.acalappv4.domain.usecase.invoice

import br.com.acalappv4.domain.datasource.InvoiceDataSource
import br.com.acalappv4.domain.dto.page.InvoicePageFilter
import br.com.acalappv4.domain.entity.Invoice
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class PaginateInvoiceUsecase(
    private val invoiceDataSource: InvoiceDataSource
): Usecase<InvoicePageFilter, Page<Invoice>> {
    override fun execute(input: InvoicePageFilter): Page<Invoice> = invoiceDataSource.paginate(input)

}