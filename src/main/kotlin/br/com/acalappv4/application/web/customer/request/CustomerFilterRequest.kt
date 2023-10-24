package br.com.acalappv4.application.web.customer.request

import br.com.acalappv4.domain.dto.list.CustomerFilter

data class CustomerFilterRequest (
    val id: String? = null,
    val name: String? = null,
    val active: Boolean? = null,
){
    fun toCustomerFilter() = CustomerFilter(
        id = id,
        name = name,
        active = active,
    )
}


