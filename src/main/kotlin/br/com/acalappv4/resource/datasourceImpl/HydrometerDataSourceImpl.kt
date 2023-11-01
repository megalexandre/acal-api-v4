package br.com.acalappv4.resource.datasourceImpl

import br.com.acalappv4.domain.datasource.HydrometerDataSource
import br.com.acalappv4.domain.dto.list.HydrometerFilter
import br.com.acalappv4.domain.dto.page.HydrometerPageFilter
import br.com.acalappv4.domain.entity.Area
import br.com.acalappv4.domain.entity.Hydrometer
import br.com.acalappv4.resource.adapter.HydrometerAdapter
import br.com.acalappv4.resource.adapter.HydrometerAdapter.Companion.toDocument
import br.com.acalappv4.resource.adapter.HydrometerAdapter.Companion.toEntity
import br.com.acalappv4.resource.adapter.toCustomer
import br.com.acalappv4.resource.adapter.toHydrometer
import br.com.acalappv4.resource.document.CustomerDocument
import br.com.acalappv4.resource.document.HydrometerDocument
import br.com.acalappv4.resource.query.CustomerQuery
import br.com.acalappv4.resource.query.HydrometerQuery
import br.com.acalappv4.resource.repository.HydrometerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class HydrometerDataSourceImpl(
    private val repository: HydrometerRepository,
    private val mongoTemplate: MongoTemplate,
): HydrometerDataSource {
    override fun save(hydrometer: Hydrometer): Hydrometer = toEntity( repository.save(toDocument(hydrometer)) )
    override fun update(hydrometer: Hydrometer): Hydrometer = toEntity( repository.save(toDocument(hydrometer)) )
    override fun delete(id: String) { repository.deleteById(id) }
    override fun findAll(): List<Hydrometer> = repository.findAll().map { toEntity(it) }
    override fun findById(id: String): Hydrometer? = repository.findById(id).map { toEntity(it) }.getOrNull()

    override fun paginate(pageFilter: HydrometerPageFilter): Page<Hydrometer> {
        val hydrometerQuery = HydrometerQuery()

        val pageable = hydrometerQuery.pageRequest(pageFilter)
        val query = hydrometerQuery.query(pageFilter.filter).with(pageable)
        val countTotal = hydrometerQuery.query(pageFilter.filter)

        val list = mongoTemplate.find(query, HydrometerDocument::class.java)
        val count: Long = mongoTemplate.count(countTotal, HydrometerDocument::class.java)
        val page = PageImpl(list, pageable, count)

        return page.toHydrometer()
    }

    override fun findAll(filter: HydrometerFilter): List<Hydrometer> =
        mongoTemplate.find(
            HydrometerQuery().query(filter),
            HydrometerDocument::class.java)
        .toHydrometer()

}