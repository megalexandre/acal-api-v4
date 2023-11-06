package br.com.acalappv4.application.web.proposal.response

import br.com.acalappv4.domain.entity.HydrometerProposal
import br.com.acalappv4.domain.entity.HydrometerProposalItem
import br.com.acalappv4.domain.entity.Reference

data class CreateProposalHydrometerResponse (
    val reference: Reference,
    val lastReference: Reference,
    val area: String,
    val hydrometers: List<HydrometerProposalItem>,
){
    constructor(hydrometerProposal: HydrometerProposal): this(
        area = hydrometerProposal.area.name,
        hydrometers = hydrometerProposal.hydrometers,
        reference = hydrometerProposal.hydrometers.first().actualCollect.reference,
        lastReference = hydrometerProposal.hydrometers.first().lastCollect.reference
    )

}
