package br.com.acalappv4.resource.resourceImpl

import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.entity.Link
import br.com.acalappv4.domain.resources.LinkResource
import br.com.acalappv4.resource.adapter.LinkAdapter.Companion.toDocument
import br.com.acalappv4.resource.adapter.LinkAdapter.Companion.toEntity
import br.com.acalappv4.resource.repository.LinkRepository
import kotlin.jvm.optionals.getOrNull
import org.springframework.stereotype.Service

@Service
class LinkResourceImpl(
    private val linkRepository: LinkRepository
): LinkResource {

    override fun existsByCustomer(customerId: String): Boolean = true

    override fun findByAddressAndStatus(address: Address, active: Boolean): Link? =
        linkRepository.findByAddressAndActive(address, active)?.map { toEntity(it) }?.getOrNull()

    override fun save(link: Link): Link = toEntity(linkRepository.save(toDocument(link)))



}