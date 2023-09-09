package br.com.acalappv4.resource.adapter

import br.com.acalappv4.domain.entity.Category
import br.com.acalappv4.resource.document.CategoryDocument

class CategoryAdapter{

    companion object{
        fun toDocument(entity: Category): CategoryDocument = with(entity){
            CategoryDocument(
                id = id,
                name = name,
                value = value,
                type = type,
            )
        }

        fun toEntity(documentItem: CategoryDocument): Category = with(documentItem){
            Category(
                id = id,
                name = name,
                value = value,
                type = type,
            )
        }
    }



}