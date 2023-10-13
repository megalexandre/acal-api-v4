package br.com.acalappv4.resource.datasourceImpl

import br.com.acalappv4.domain.datasource.AreaDataSource
import br.com.acalappv4.domain.dto.page.PageFilterArea
import br.com.acalappv4.domain.entity.Area
import br.com.acalappv4.resource.adapter.AreaAdapter.Companion.toDocument
import br.com.acalappv4.resource.adapter.AreaAdapter.Companion.toEntity
import br.com.acalappv4.resource.adapter.toArea
import br.com.acalappv4.resource.document.AreaDocument
import br.com.acalappv4.resource.event.Event.AREA_UPDATED
import br.com.acalappv4.resource.event.UpdatedDocumentEvent
import br.com.acalappv4.resource.query.AreaQuery
import br.com.acalappv4.resource.repository.AreaRepository
import br.com.acalappv4.util.normalize
import kotlin.jvm.optionals.getOrNull
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AreaDataSourceImpl(
    private val repository: AreaRepository,
    private val mongoTemplate: MongoTemplate,
    private val publisher: ApplicationEventPublisher,
): AreaDataSource {

    override fun findByName(name: String): Area? = repository.findByNameNormalized(name.normalize())
        .map { toEntity(it) }.getOrNull()

    @Transactional
    override fun update(area: Area): Area =
        toEntity(repository.save(toDocument(area)).also {
            publisher.publishEvent(UpdatedDocumentEvent(AREA_UPDATED.name, it))
        })

    override fun save(area: Area): Area =
        toEntity(repository.save(toDocument(area)))

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