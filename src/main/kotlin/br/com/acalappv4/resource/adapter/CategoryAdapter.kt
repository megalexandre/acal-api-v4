package br.com.acalappv4.resource.adapter

import br.com.acalappv4.domain.entity.Category
import br.com.acalappv4.resource.document.CategoryDocument
import br.com.acalappv4.util.normalize
import org.springframework.data.domain.Page

class CategoryAdapter{

    companion object{
        fun toDocument(entity: Category): CategoryDocument = with(entity){
            CategoryDocument(
                id = id,
                name = name,
                nameNormalized = name.normalize(),
                waterValue =  waterValue,
                categoryValue = categoryValue,
                totalValue = waterValue + categoryValue,
                type = type,
            )
        }

        fun toEntity(documentItem: CategoryDocument): Category = with(documentItem){
            Category(
                id = id,
                name = name,
                waterValue =  waterValue,
                categoryValue = categoryValue,
                type = type,
            )
        }
    }

}


fun Page<CategoryDocument>.toCategory() = map { CategoryAdapter.toEntity(it)  }