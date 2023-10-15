package br.com.acalappv4.application.web.proposal

import br.com.acalappv4.application.web.proposal.request.CreateProposalRequest
import br.com.acalappv4.domain.usecase.invoice.ListInvoiceProposalUsecase
import jakarta.validation.Valid
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("proposal", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
class ProposalController(
    private val listProposal: ListInvoiceProposalUsecase,
) {
    @PostMapping
    fun createProposal(@Valid @RequestBody request: CreateProposalRequest) =
        ok(listProposal.execute(request.reference))

}