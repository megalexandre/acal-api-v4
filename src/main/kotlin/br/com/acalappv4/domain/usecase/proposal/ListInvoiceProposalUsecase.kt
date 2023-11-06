package br.com.acalappv4.domain.usecase.proposal

import br.com.acalappv4.common.enums.Reason.*
import br.com.acalappv4.domain.dto.list.InvoiceFilter
import br.com.acalappv4.domain.dto.list.LinkFilter
import br.com.acalappv4.domain.entity.*
import br.com.acalappv4.domain.usecase.Usecase
import br.com.acalappv4.domain.usecase.invoice.ExistsInvoiceByLinkAndReferenceProposalUsecase
import br.com.acalappv4.domain.usecase.invoiceNumber.GetNextInvoiceNumberUsecase
import br.com.acalappv4.domain.usecase.link.FindAllLinkUsecase
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDateTime.now

@Service
class ListInvoiceProposalUsecase(
    private val linkListUsecase: FindAllLinkUsecase,
    private val existsInvoiceUsecase: ExistsInvoiceByLinkAndReferenceProposalUsecase,
    private val getNextInvoiceNumberUsecase: GetNextInvoiceNumberUsecase,
) : Usecase<Reference, List<InvoiceProposal>> {

    override fun execute(input: Reference): List<InvoiceProposal> = createProposal(allProposal(input))

    private fun createProposal(allProposal: List<InvoiceProposalItem>): List<InvoiceProposal> =
        allProposal
            .distinctBy { it.address.area.name }
            .sortedBy { it.address.area.name }
            .map {invoiceProposal ->
                InvoiceProposal(
                    area = invoiceProposal.address.area.name,
                    invoices = allProposal
                        .filter { it.address.area.id == invoiceProposal.address.area.id }
                        .sortedBy { it.address.area.name }
                )
            }

    private fun allProposal(input: Reference): List<InvoiceProposalItem> = linkListUsecase
        .execute(LinkFilter(active = true))
        .filter { !existsInvoiceUsecase.execute(InvoiceFilter(reference = input, linkId = it.id)) }
        .map {
            InvoiceProposalItem(
                reference = input,
                emission = now(),
                linkDetail = LinkDetail(
                    linkId = it.id,
                    address = it.address.alias,
                    customer = it.customer.name
                ) ,
                address = it.address,
                number = getNextInvoiceNumberUsecase.execute(input),
                invoiceDetails = listOf(
                    InvoiceDetail(
                        reason = CATEGORY,
                        value = it.category.categoryValue,
                        dataPaid = null
                    ),
                    InvoiceDetail(
                        reason = WATER,
                        value = it.category.waterValue,
                        dataPaid = null
                    ),
                    InvoiceDetail(
                        reason = HYDROMETER,
                        value = BigDecimal.ZERO,
                        dataPaid = null
                    )
                )
            )
    }
}