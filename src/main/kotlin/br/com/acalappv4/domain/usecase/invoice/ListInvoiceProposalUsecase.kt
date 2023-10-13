package br.com.acalappv4.domain.usecase.invoice

import br.com.acalappv4.common.enums.Reason
import br.com.acalappv4.domain.dto.list.InvoiceFilter
import br.com.acalappv4.domain.dto.list.LinkFilter
import br.com.acalappv4.domain.entity.Invoice
import br.com.acalappv4.domain.entity.InvoiceDetail
import br.com.acalappv4.domain.entity.InvoiceProposal
import br.com.acalappv4.domain.entity.LinkDetail
import br.com.acalappv4.domain.usecase.Usecase
import br.com.acalappv4.domain.usecase.link.FindAllLinkUsecase
import io.azam.ulidj.ULID.random
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ListInvoiceProposalUsecase(
    private val linkListUsecase: FindAllLinkUsecase,
    private val existsInvoiceUsecase: ExistsInvoiceByLinkAndReferenceProposalUsecase
) : Usecase<InvoiceProposal, List<Invoice>> {

    override fun execute(input: InvoiceProposal): List<Invoice> =
        linkListUsecase
            .execute(LinkFilter(active = true))
            .filter { !existsInvoiceUsecase.execute(InvoiceFilter(reference = input.reference, link = it)) }
            .map {
                Invoice(
                    id = random(),
                    reference = input.reference,
                    dueDate = input.dueDate,
                    emission = LocalDateTime.now(),
                    linkDetail = LinkDetail(
                        linkId = it.id,
                        customer = it.customer.name
                    ) ,
                    invoiceDetails = listOf(
                        InvoiceDetail(
                            reason = Reason.CATEGORY,
                            value = it.category.categoryValue,
                            dataPaid = null
                        ),
                        InvoiceDetail(
                            reason = Reason.WATER,
                            value = it.category.waterValue,
                            dataPaid = null
                        ),
                    ),
                )
            }
}