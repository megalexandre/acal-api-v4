package br.com.acalappv4.domain.entity

class HydrometerProposal(
    val area: Area,
    val hydrometers: List<HydrometerProposalItem>,
)

class HydrometerProposalItem(
    val address: Address,
    val actualCollect: HydrometerProposalCollect,
    val lastCollect: HydrometerProposalCollect,
)

class HydrometerProposalCollect(
    val reference: Reference,
    val totalMeter: Long?,
)


