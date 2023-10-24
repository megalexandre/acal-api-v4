package br.com.acalappv4.domain.dto.list

import br.com.acalappv4.domain.entity.Address

class LinkFilter(
    val id: String? = null,
    val customer: CustomerFilter? = null,
    val category: CategoryFilter? = null,
    val area: AreaFilter? = null,
    val address: Address? = null,
    val addressMail: Address ? = null,
    val active: Boolean? = null,
    val createdBy: String ? = null,
): DefaultFilter