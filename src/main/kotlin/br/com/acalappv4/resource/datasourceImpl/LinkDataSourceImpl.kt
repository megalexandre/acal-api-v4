package br.com.acalappv4.resource.datasourceImpl

import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.entity.Link
import br.com.acalappv4.domain.datasource.LinkDataSource
import br.com.acalappv4.resource.adapter.LinkAdapter.Companion.toDocument
import br.com.acalappv4.resource.adapter.LinkAdapter.Companion.toEntity
import br.com.acalappv4.resource.repository.LinkRepository
import kotlin.jvm.optionals.getOrNull
import org.springframework.stereotype.Service

@Service
class LinkDataSourceImpl(
    private val linkRepository: LinkRepository
): LinkDataSource {

    override fun existsByCustomer(customerId: String): Boolean = true

    override fun findByAddressAndStatus(address: Address, active: Boolean): Link? =
        linkRepository.findByAddressAndActive(address, active)?.map { toEntity(it) }?.getOrNull()

    override fun save(link: Link): Link = toEntity(linkRepository.save(toDocument(link)))



}