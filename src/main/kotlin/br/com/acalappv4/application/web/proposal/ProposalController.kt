package br.com.acalappv4.application.web.proposal

import br.com.acalappv4.application.web.proposal.request.ProposalCreateRequest
import br.com.acalappv4.application.web.proposal.response.CreateProposalHydrometerResponse
import br.com.acalappv4.application.web.proposal.response.CreateProposalResponse
import br.com.acalappv4.domain.usecase.proposal.ListHydrometerProposalUsecase
import br.com.acalappv4.domain.usecase.proposal.ListInvoiceProposalUsecase
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
    private val listHydrometerProposalUsecase: ListHydrometerProposalUsecase,
) {
    @PostMapping
    fun createProposal(@Valid @RequestBody request: ProposalCreateRequest) =
        ok(listProposal.execute(request.reference).map { CreateProposalResponse(it) })

    @PostMapping("hydrometer")
    fun createHydrometerProposal(@Valid @RequestBody request: ProposalCreateRequest) =
        ok(listHydrometerProposalUsecase.execute(request.reference).map{ CreateProposalHydrometerResponse(it) })

}