package br.com.acalappv4.resource.datasourceImpl

import br.com.acalappv4.common.enums.CategoryType
import br.com.acalappv4.domain.dto.PageFilterCategory
import br.com.acalappv4.domain.entity.Category
import br.com.acalappv4.domain.datasource.CategoryDataSource
import br.com.acalappv4.resource.adapter.CategoryAdapter.Companion.toDocument
import br.com.acalappv4.resource.adapter.CategoryAdapter.Companion.toEntity
import br.com.acalappv4.resource.adapter.toCategory
import br.com.acalappv4.resource.document.CategoryDocument
import br.com.acalappv4.resource.query.CategoryQuery
import br.com.acalappv4.resource.repository.CategoryRepository
import kotlin.jvm.optionals.getOrNull
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository


@Repository
class CategoryDataSourceImpl(
    private val repository: CategoryRepository,
    private val mongoTemplate: MongoTemplate,
): CategoryDataSource {

    override fun save(category: Category): Category =
        toEntity(repository.save(toDocument(category)))

    override fun delete(id: String) =
        repository.deleteById(id)

    override fun findByNameAndType(name: String, type: CategoryType): Category? =
        repository.findByNameAndType(name, type).map { toEntity(it) }
        .getOrNull()

    override fun findAll(): List<Category> =
        repository.findAll()
            .map { toEntity(it) }

    override fun findById(id: String): Category? =
        repository.findById(id)
        .map { toEntity(it) }
        .getOrNull()

    override fun paginate(pageFilterCategory: PageFilterCategory): Page<Category> {
        val categoryQuery = CategoryQuery(pageFilterCategory)

        val pageable = categoryQuery.pageRequest()
        val query = categoryQuery.query().with(pageable)

        val list = mongoTemplate.find(query, CategoryDocument::class.java)
        val count: Long = mongoTemplate.count(query, CategoryDocument::class.java)
        val page = PageImpl(list, pageable, count)

        return page.toCategory()
    }


}