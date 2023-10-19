package br.com.acalappv4.domain.dto.list

import br.com.acalappv4.common.enums.PersonType
import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.entity.Category
import br.com.acalappv4.domain.entity.Customer

class CustomerFilter(
    val id: String? = null,
    val name: String? = null,
    val documentNumber: String? = null,
    val personType: PersonType? = null,
    val active: Boolean? = null,
): DefaultFilter
