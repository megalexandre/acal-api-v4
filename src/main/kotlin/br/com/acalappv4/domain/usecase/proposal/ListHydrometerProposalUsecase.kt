package br.com.acalappv4.domain.usecase.proposal

import br.com.acalappv4.domain.dto.list.AddressFilter
import br.com.acalappv4.domain.dto.list.HydrometerFilter
import br.com.acalappv4.domain.entity.*
import br.com.acalappv4.domain.usecase.Usecase
import br.com.acalappv4.domain.usecase.address.FindAllAddressUsecase
import br.com.acalappv4.domain.usecase.hydrometer.FindAllHydrometerUsecase
import org.springframework.stereotype.Service

@Service
class ListHydrometerProposalUsecase(
    private val usecase: FindAllHydrometerUsecase,
    private val findAllAddressUsecase: FindAllAddressUsecase,
    ) : Usecase<Reference, List<HydrometerProposal>> {

    override fun execute(input: Reference): List<HydrometerProposal> {
        val hydrometers = usecase.execute(HydrometerFilter(reference = input))
        val address = findAllAddressUsecase.execute(AddressFilter(hasHydrometer = true))
        val areas = address.map { it.area }.distinctBy { it.id }.sortedBy { it.name }

        val proposals = areas.map { area ->
            HydrometerProposal(
                area = area,
                hydrometers = getHydrometerProposal(area, address, hydrometers, input)
            )
        }

        return proposals
    }

    private fun getHydrometerProposal(
            area: Area,
            address: List<Address>,
            hydrometers: List<Hydrometer>,
            reference: Reference): List<HydrometerProposalItem> =

        address
            .filter { it.area.id == area.id }

            .map {
            getHydrometerItem(it, reference, hydrometers)
        }

    private fun getHydrometerItem(
        address: Address,
        reference: Reference,
        hydrometers: List<Hydrometer>): HydrometerProposalItem {

        return when (val hydrometer = hydrometers.find { it.address.id == address.id  && it.reference == reference}){
            null -> {
                HydrometerProposalItem(
                    address = address,
                    actualCollect = HydrometerProposalCollect(
                        reference = reference, totalMeter = null),
                    lastCollect = HydrometerProposalCollect(
                        reference = reference.minusMonth(1), totalMeter = null),
                )
            }
            else -> {
                HydrometerProposalItem(
                    address = address,

                    actualCollect = HydrometerProposalCollect(
                        reference = hydrometer.actualCollect.reference, totalMeter = hydrometer.actualCollect.totalMeter),

                    lastCollect = HydrometerProposalCollect(
                        reference =  hydrometer.lastCollect.reference, totalMeter = hydrometer.lastCollect.totalMeter),
                )
            }
        }
    }
}