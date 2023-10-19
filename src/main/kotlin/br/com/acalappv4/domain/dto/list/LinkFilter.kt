package br.com.acalappv4.domain.dto.list

import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.entity.Category
import br.com.acalappv4.domain.entity.Customer

class LinkFilter(
    val id: String? = null,
    val category: Category? = null,
    val address: Address? = null,
    val addressMail: Address ? = null,
    val customer: Customer? = null,
    val active: Boolean? = null,
    val createdBy: String ? = null,
): DefaultFilter