package br.com.acalappv4.resource.adapter

import br.com.acalappv4.domain.entity.Category
import br.com.acalappv4.resource.document.CategoryDocument
import br.com.acalappv4.util.normalize
import br.com.acalappv4.util.toCurrency
import java.math.BigDecimal
import java.math.RoundingMode.HALF_UP
import org.springframework.data.domain.Page

class CategoryAdapter{

    companion object{
        fun toDocument(entity: Category): CategoryDocument = with(entity){
            CategoryDocument(
                id = id,
                name = name,
                nameNormalized = name.normalize(),
                waterValue =  waterValue.toCurrency(),
                categoryValue = categoryValue.toCurrency(),
                totalValue = waterValue.add(categoryValue).toCurrency(),
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