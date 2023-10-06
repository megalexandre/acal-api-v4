package br.com.acalappv4.resource.datasourceImpl

import br.com.acalappv4.domain.datasource.LinkDataSource
import br.com.acalappv4.domain.dto.PageFilterLink
import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.entity.Link
import br.com.acalappv4.resource.adapter.LinkAdapter.Companion.toDocument
import br.com.acalappv4.resource.adapter.LinkAdapter.Companion.toEntity
import br.com.acalappv4.resource.adapter.toLink
import br.com.acalappv4.resource.document.AddressDocument
import br.com.acalappv4.resource.document.LinkDocument
import br.com.acalappv4.resource.event.UpdatedDocumentEvent
import br.com.acalappv4.resource.query.LinkQuery
import br.com.acalappv4.resource.repository.LinkRepository
import kotlin.jvm.optionals.getOrNull
import org.springframework.context.event.EventListener
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class LinkDataSourceImpl(
    private val repository: LinkRepository,
    private val mongoTemplate: MongoTemplate,
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

    override fun existsByCustomer(customerId: String): Boolean =
        !repository.findByCustomerId(customerId).isNullOrEmpty()

    override fun findByAddressAndStatus(address: Address, active: Boolean): Link? =
        repository.findByAddressIdAndActive(address.id, active)?.map { toEntity(it) }?.getOrNull()

    override fun save(link: Link): Link = toEntity(repository.save(toDocument(link)))

    override fun findAll(): List<Link> =  repository.findAll().map { toEntity(it) }

    override fun paginate(pageFilterLink: PageFilterLink): Page<Link> {
        val linkQuery = LinkQuery(pageFilterLink)

        val pageable = linkQuery.pageRequest()
        val query = linkQuery.query().with(pageable)
        val countTotal = linkQuery.query()

        val list = mongoTemplate.find(query, LinkDocument::class.java)
        val count: Long = mongoTemplate.count(countTotal, LinkDocument::class.java)
        val page = PageImpl(list, pageable, count)

        return page.toLink()
    }

}