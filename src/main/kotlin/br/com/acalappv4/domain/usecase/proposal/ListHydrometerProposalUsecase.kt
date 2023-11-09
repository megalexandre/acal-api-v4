package br.com.acalappv4.domain.usecase.proposal

import br.com.acalappv4.domain.dto.list.AddressFilter
import br.com.acalappv4.domain.dto.list.HydrometerFilter
import br.com.acalappv4.domain.dto.list.LinkFilter
import br.com.acalappv4.domain.entity.*
import br.com.acalappv4.domain.usecase.Usecase
import br.com.acalappv4.domain.usecase.address.FindAllAddressUsecase
import br.com.acalappv4.domain.usecase.hydrometer.FindAllHydrometerUsecase
import br.com.acalappv4.domain.usecase.link.FindAllLinkUsecase
import org.springframework.stereotype.Service

@Service
class ListHydrometerProposalUsecase(
    private val usecase: FindAllHydrometerUsecase,
    private val findAllAddressUsecase: FindAllAddressUsecase,
    private val findAllLink: FindAllLinkUsecase,
    private val findAllHydrometer: FindAllHydrometerUsecase
) : Usecase<Reference, List<HydrometerProposal>> {

    override fun execute(input: Reference): List<HydrometerProposal> {
        val lastReference = input.minusMonth(1)

        val hydrometers = findAllHydrometer.execute(HydrometerFilter(reference = input))

        val lastMonthHydrometers = usecase.execute(HydrometerFilter(reference = lastReference))

        val links = findAllLink.execute(LinkFilter(active = true))
        val address = findAllAddressUsecase.execute(AddressFilter(hasHydrometer = true)).filter { address ->
            links.any { address.id ==  it.address.id}
        }

        val areas = address.map { it.area }.distinctBy { it.id }.sortedBy { it.name }

        val proposals = areas.map { area ->
            HydrometerProposal(
                area = area,
                hydrometers = getHydrometerProposal(
                    area, address, hydrometers,lastMonthHydrometers, input,lastReference
                )
            )
        }

        return proposals
    }

    private fun getHydrometerProposal(
            area: Area,
            address: List<Address>,
            hydrometers: List<Hydrometer>,
            lastMonthHydrometers: List<Hydrometer>,
            actualReference: Reference,
            lastReference: Reference

    ): List<HydrometerProposalItem> =

        address
            .filter { it.area.id == area.id }
            .map {
            getHydrometerItem(
                address = it,
                hydrometers = hydrometers,
                lastMonthHydrometers = lastMonthHydrometers,
                actualReference = actualReference,
                lastReference = lastReference,
            )
        }

    private fun getHydrometerItem(
        address: Address,
        hydrometers: List<Hydrometer>,
        lastMonthHydrometers: List<Hydrometer>,
        actualReference: Reference,
        lastReference: Reference,
    ): HydrometerProposalItem {

        return when (val hydrometer = hydrometers.find { it.address.id == address.id  && it.reference == actualReference}){
            null -> {
                HydrometerProposalItem(
                    address = address,
                    actualCollect = HydrometerProposalCollect(
                        reference = actualReference, totalMeter = null),
                        lastCollect = HydrometerProposalCollect(
                        reference = lastReference,
                        totalMeter = getMeterFromHydrometer(lastMonthHydrometers, address, lastReference)
                    ),
                )
            }
            else -> {
                HydrometerProposalItem(
                    address = address,
                    actualCollect = createHydrometerProposalCollect(hydrometer.actualCollect),
                    lastCollect = createHydrometerProposalCollect(hydrometer.lastCollect)
                )
            }
        }
    }

    private fun getMeterFromHydrometer(
        lastMonthHydrometers: List<Hydrometer>,
       address: Address,
       lastReference: Reference
    ) = lastMonthHydrometers.find {
        it.address.id == address.id && it.reference == lastReference
    }?.actualCollect?.totalMeter ?: 0


    private fun createHydrometerProposalCollect(hydrometerCollect: HydrometerCollect) =
        HydrometerProposalCollect(
            reference = hydrometerCollect.reference,
            totalMeter = hydrometerCollect.totalMeter
        )
}