package br.com.acalappv4.resource.repository

import br.com.acalappv4.common.enums.CategoryType
import br.com.acalappv4.resource.document.CategoryDocument
import java.util.Optional
import org.springframework.data.mongodb.repository.MongoRepository

interface CategoryRepository : MongoRepository<CategoryDocument, String>{

    fun findByNameAndType(name: String, type: CategoryType): Optional<CategoryDocument>

}