package br.com.acalappv4.application.web.invoice

import br.com.acalappv4.application.web.invoice.request.CreateInvoiceProposalRequest
import br.com.acalappv4.domain.usecase.invoice.ListInvoiceProposalUsecase
import jakarta.validation.Valid
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("invoice", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
class InvoiceController(
    private val listProposal: ListInvoiceProposalUsecase,
) {

    @PostMapping("proposal")
    fun listProposal(@Valid @RequestBody request: CreateInvoiceProposalRequest) =
        listProposal.execute(request.toInvoiceProposal())

}