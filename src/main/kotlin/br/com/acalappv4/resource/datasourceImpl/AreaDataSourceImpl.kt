package br.com.acalappv4.resource.datasourceImpl

import br.com.acalappv4.domain.datasource.AreaDataSource
import br.com.acalappv4.domain.dto.PageFilterArea
import br.com.acalappv4.domain.entity.Area
import br.com.acalappv4.resource.adapter.AreaAdapter.Companion.toDocument
import br.com.acalappv4.resource.adapter.AreaAdapter.Companion.toEntity
import br.com.acalappv4.resource.adapter.toArea
import br.com.acalappv4.resource.document.AreaDocument
import br.com.acalappv4.resource.query.AreaQuery
import br.com.acalappv4.resource.repository.AddressRepository
import br.com.acalappv4.resource.repository.AreaRepository
import br.com.acalappv4.util.normalize
import kotlin.jvm.optionals.getOrNull
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class AreaDataSourceImpl(
    private val repository: AreaRepository,
    private val addressRepository: AddressRepository,
    private val mongoTemplate: MongoTemplate,
): AreaDataSource {

    override fun findByName(name: String): Area? = repository.findByNameNormalized(name.normalize())
        .map { toEntity(it) }.getOrNull()

    override fun save(area: Area): Area {
        val areaDocument: AreaDocument = repository.save(toDocument(area))

        addressRepository.findByAreaId(area.id)?.forEach {
            addressRepository.save(
                it.copy(area = areaDocument.copy(
                    name = areaDocument.name,
                    nameNormalized = areaDocument.nameNormalized
                ))
            )
        }

        return toEntity(areaDocument)
    }



    override fun delete(id: String) = repository.deleteById(id)

    override fun paginate(pageFilterArea: PageFilterArea): Page<Area> {
        val areaQuery = AreaQuery(pageFilterArea)

        val pageable = areaQuery.pageRequest()
        val query = areaQuery.query().with(pageable)

        val list = mongoTemplate.find(query, AreaDocument::class.java)
        val count: Long = mongoTemplate.count(query, AreaDocument::class.java)
        val page = PageImpl(list, pageable, count)

        return page.toArea()
    }

    override fun findAll(): List<Area> = repository.findAll().map { toEntity(it) }

    override fun findById(id: String): Area? = repository.findById(id)
        .map { toEntity(it) }.getOrNull()

}