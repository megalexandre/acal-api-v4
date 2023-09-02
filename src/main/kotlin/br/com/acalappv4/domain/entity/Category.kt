package br.com.acalappv4.domain.entity

import br.com.acalappv4.common.enums.CategoryType
import java.math.BigDecimal

class Category(

    val id: String,
    val name: String,
    val value: BigDecimal,
    val type: CategoryType,

)