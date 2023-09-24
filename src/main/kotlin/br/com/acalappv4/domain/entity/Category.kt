package br.com.acalappv4.domain.entity

import br.com.acalappv4.common.enums.CategoryType
import br.com.acalappv4.domain.entity.interfaces.Entity
import br.com.acalappv4.domain.exception.InvalidUsecaseException
import java.math.BigDecimal
import java.math.BigDecimal.ZERO

class Category(

    val id: String,
    val name: String,
    val waterValue: BigDecimal,
    val categoryValue: BigDecimal,
    val type: CategoryType,

): Entity {

    init {
        if(waterValue < ZERO ){
            throw InvalidUsecaseException("water value can't be less than zero")       }

        if(categoryValue < ZERO ){
            throw InvalidUsecaseException("Category value can't be less than zero")       }
    }

}