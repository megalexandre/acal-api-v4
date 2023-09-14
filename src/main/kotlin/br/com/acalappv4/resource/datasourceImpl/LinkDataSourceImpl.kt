package br.com.acalappv4.resource.datasourceImpl

import br.com.acalappv4.domain.datasource.LinkDataSource
import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.entity.Link
import br.com.acalappv4.resource.adapter.LinkAdapter.Companion.toDocument
import br.com.acalappv4.resource.adapter.LinkAdapter.Companion.toEntity
import br.com.acalappv4.resource.document.AddressDocument
import br.com.acalappv4.resource.event.UpdatedDocumentEvent
import br.com.acalappv4.resource.repository.LinkRepository
import kotlin.jvm.optionals.getOrNull
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class LinkDataSourceImpl(
    private val repository: LinkRepository
): LinkDataSource {

    @EventListener(condition = "#event.name eq 'ADDRESS_UPDATED'")
    fun addressUpdated(event: UpdatedDocumentEvent) {

        if(event.payload is AddressDocument){
            val address: AddressDocument = event.payload

            repository.findByAddressId(address.id)?.let { links ->
                repository.saveAll(links.map {it.copy(address = address) })
            }

            repository.findByAddressMailId(address.id)?.let { links ->
                repository.saveAll(links.map {it.copy(addressMail = address) })
            }

        }
    }


    override fun existsByCustomer(customerId: String): Boolean = true

    override fun findByAddressAndStatus(address: Address, active: Boolean): Link? =
        repository.findByAddressAndActive(address, active)?.map { toEntity(it) }?.getOrNull()

    override fun save(link: Link): Link = toEntity(repository.save(toDocument(link)))

    override fun findAll(): List<Link> =  repository.findAll().map { toEntity(it) }

}