package br.com.acalappv4.application.web.link.request

import br.com.acalappv4.application.web.area.request.AreaFilterRequest
import br.com.acalappv4.application.web.category.request.CategoryFilterRequest
import br.com.acalappv4.application.web.customer.request.CustomerFilterRequest
import br.com.acalappv4.domain.dto.list.LinkFilter
import br.com.acalappv4.domain.dto.page.LinkPageFilter
import br.com.acalappv4.domain.dto.page.Page
import br.com.acalappv4.domain.dto.page.Sort

class LinkPageFilterRequest(
    val id: String? = null,
    val customer: CustomerFilterRequest? = null,
    val category: CategoryFilterRequest? = null,
    val area: AreaFilterRequest? = null,
    val active: Boolean? = null,
    val createdBy: String ? = null,
    val page: Page?,
    val sort: Sort?,
){

    fun toEntity(): LinkPageFilter = LinkPageFilter(
        linkFilter = LinkFilter(
            id = id,
            customer = customer?.toCustomerFilter(),
            category = category?.toCategoryFilter(),
            area = area?.toAreaFilter(),
            active = active,
            createdBy = createdBy
        ),
        page = page,
        sort = sort,
    )
}