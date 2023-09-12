package br.com.acalappv4.resource.document

import br.com.acalappv4.common.enums.CategoryType
import java.math.BigDecimal
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "category")
class CategoryDocument (

    @Id
    val id: String,

    val name: String,

    val nameNormalized: String,

    val value: BigDecimal,

    val type: CategoryType,

): DocumentItem