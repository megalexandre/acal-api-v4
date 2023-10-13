package br.com.acalappv4.domain.usecase.invoice

import br.com.acalappv4.domain.datasource.InvoiceDataSource
import br.com.acalappv4.domain.dto.list.InvoiceFilter
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class ExistsInvoiceByLinkAndReferenceProposalUsecase(
    private val invoiceDataSource: InvoiceDataSource
): Usecase<InvoiceFilter, Boolean> {

    override fun execute(input: InvoiceFilter): Boolean = invoiceDataSource.exists(input)

}