package br.com.acalappv4.domain.datasource

import br.com.acalappv4.common.enums.CategoryType
import br.com.acalappv4.domain.dto.page.CategoryPageFilter
import br.com.acalappv4.domain.entity.Category
import org.springframework.data.domain.Page

interface CategoryDataSource {

    fun save(category: Category): Category

    fun delete(id: String): Unit

    fun paginate(categoryPageFilter: CategoryPageFilter): Page<Category>

    fun findByNameAndType(name: String, type: CategoryType): Category?

    fun findAll(): List<Category>

    fun findById(id: String): Category?

}