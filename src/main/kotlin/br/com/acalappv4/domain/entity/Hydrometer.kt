package br.com.acalappv4.domain.entity

import br.com.acalappv4.common.enums.CategoryType
import br.com.acalappv4.domain.entity.interfaces.Entity
import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.util.toCurrency
import java.math.BigDecimal
import java.math.BigDecimal.ZERO

class Hydrometer(

    val id: String,
    val reference: Reference,
    val expenditure: Long,
    val waterValue: BigDecimal,

): Entity {

}