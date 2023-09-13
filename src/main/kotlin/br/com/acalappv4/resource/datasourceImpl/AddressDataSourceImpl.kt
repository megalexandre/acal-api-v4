package br.com.acalappv4.resource.datasourceImpl

import br.com.acalappv4.domain.datasource.AddressDataSource
import br.com.acalappv4.domain.dto.PageFilterAddress
import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.resource.adapter.AddressAdapter.Companion.toDocument
import br.com.acalappv4.resource.adapter.AddressAdapter.Companion.toEntity
import br.com.acalappv4.resource.adapter.toAddress
import br.com.acalappv4.resource.document.AddressDocument
import br.com.acalappv4.resource.query.AddressQuery
import br.com.acalappv4.resource.repository.AddressRepository
import kotlin.jvm.optionals.getOrNull
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class AddressDataSourceImpl(
    private val repository: AddressRepository,
    private val mongoTemplate: MongoTemplate,
): AddressDataSource {

    override fun save(address: Address): Address = toEntity(repository.save(toDocument(address)))

    override fun delete(id: String) = repository.deleteById(id)

    override fun paginate(pageFilterAddress: PageFilterAddress): Page<Address> {
        val areaQuery = AddressQuery(pageFilterAddress)

        val pageable = areaQuery.pageRequest()
        val query = areaQuery.query().with(pageable)

        val list = mongoTemplate.find(query, AddressDocument::class.java)
        val count: Long = mongoTemplate.count(query, AddressDocument::class.java)
        val page = PageImpl(list, pageable, count)

        return page.toAddress()
    }

    override fun findAll(): List<Address> =
        repository.findAll().map { toEntity(it) }

    override fun findAll(pageFilterAddress: PageFilterAddress): List<Address> =
        mongoTemplate.find( AddressQuery(pageFilterAddress).query(), AddressDocument::class.java).map { toEntity(it) }

    override fun findById(id: String): Address? = repository.findById(id)
        .map { toEntity(it) }.getOrNull()

}