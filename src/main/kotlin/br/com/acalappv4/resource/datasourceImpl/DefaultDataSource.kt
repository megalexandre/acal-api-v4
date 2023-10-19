package br.com.acalappv4.resource.datasourceImpl

import br.com.acalappv4.domain.entity.interfaces.Entity
import br.com.acalappv4.resource.adapter.ResourceAdapter
import br.com.acalappv4.resource.document.DocumentItem
import org.springframework.data.mongodb.repository.MongoRepository


abstract class DefaultDataSource(
    private val adapter: ResourceAdapter<DocumentItem, Entity>,
    private val repository: MongoRepository<DocumentItem, String>
) {
    fun save(entity: Entity): Entity = adapter.toEntity(repository.save(adapter.toDocument(entity)))



   // fun save(address: Address): Address = toEntity(repository.save(toDocument(address)))

    /*
    @Transactional
    override fun update(address: Address): Address =
        toEntity(repository.save(toDocument(address)).also {
            publisher.publishEvent(UpdatedDocumentEvent(ADDRESS_UPDATED.name, it))
        })

    override fun save(address: Address): Address = toEntity(repository.save(toDocument(address)))

    override fun delete(id: String) = repository.deleteById(id)

    override fun paginate(addressPageFilter: AddressPageFilter): Page<Address> {
        val areaQuery = AddressQuery()

        val pageable = areaQuery.pageRequest(addressPageFilter)
        val query = areaQuery.query(addressPageFilter.filter).with(pageable)
        val countTotal = areaQuery.query(addressPageFilter.filter)

        val list = mongoTemplate.find(query, AddressDocument::class.java)
        val count: Long = mongoTemplate.count(countTotal, AddressDocument::class.java)
        val page = PageImpl(list, pageable, count)

        return page.toAddress()
    }

    override fun findAll(addressPageFilter: AddressPageFilter): List<Address> =
        mongoTemplate.find(
            AddressQuery().query(addressPageFilter.filter), AddressDocument::class.java)
            .map { toEntity(it) }

    override fun findAll(): List<Address> =
        repository.findAll().map { toEntity(it) }

    override fun findById(id: String): Address? = repository.findById(id)
        .map { toEntity(it) }.getOrNull()
    */
}