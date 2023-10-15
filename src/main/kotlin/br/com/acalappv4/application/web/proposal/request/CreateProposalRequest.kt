package br.com.acalappv4.application.web.proposal.request

import br.com.acalappv4.application.web.components.validation.ValidReference
import br.com.acalappv4.domain.entity.Reference
import org.springframework.validation.annotation.Validated

@Validated
data class CreateProposalRequest (
    @ValidReference
    val reference: Reference,
)
