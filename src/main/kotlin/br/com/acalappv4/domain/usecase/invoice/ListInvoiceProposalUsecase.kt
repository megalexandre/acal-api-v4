package br.com.acalappv4.domain.usecase.invoice

import br.com.acalappv4.common.enums.Reason.CATEGORY
import br.com.acalappv4.common.enums.Reason.WATER
import br.com.acalappv4.domain.dto.list.InvoiceFilter
import br.com.acalappv4.domain.dto.list.LinkFilter
import br.com.acalappv4.domain.entity.*
import br.com.acalappv4.domain.usecase.Usecase
import br.com.acalappv4.domain.usecase.link.FindAllLinkUsecase
import org.springframework.stereotype.Service
import java.time.LocalDateTime.now

@Service
class ListInvoiceProposalUsecase(
    private val linkListUsecase: FindAllLinkUsecase,
    private val existsInvoiceUsecase: ExistsInvoiceByLinkAndReferenceProposalUsecase,
) : Usecase<Reference, List<Proposal>> {

    override fun execute(input: Reference): List<Proposal>{
        val allProposal = allProposal(input)
        return allProposal
            .distinctBy { it.address.area.name }
            .sortedBy { it.address.area.name }
            .map {invoiceProposal ->
                Proposal(
                    area = invoiceProposal.address.area.name,
                    invoices = allProposal.filter { it.address.area.id == invoiceProposal.address.area.id }
                )
            }
    }






    private fun allProposal(input: Reference): List<InvoiceProposal> = linkListUsecase
        .execute(LinkFilter(active = true))
        .filter { !existsInvoiceUsecase.execute(InvoiceFilter(reference = input, link = it)) }
        .map {
            InvoiceProposal(
                reference = input,
                emission = now(),
                linkDetail = LinkDetail(
                    linkId = it.id,
                    customer = it.customer.name
                ) ,
                address = it.address,
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
                )
            )
    }
}