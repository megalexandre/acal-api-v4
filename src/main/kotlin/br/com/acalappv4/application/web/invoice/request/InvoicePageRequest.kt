package br.com.acalappv4.application.web.invoice.request

import br.com.acalappv4.domain.dto.list.InvoiceFilter
import br.com.acalappv4.domain.dto.page.InvoicePageFilter
import br.com.acalappv4.domain.dto.page.Page
import br.com.acalappv4.domain.dto.page.Sort
import br.com.acalappv4.domain.entity.Reference

class InvoicePageRequest(
    val id: String?,
    val reference: Reference?,
    val linkId: String?,
    val page: Page?,
    val sort: Sort?,
){
    fun toEntity(): InvoicePageFilter =
        InvoicePageFilter(
            filter = InvoiceFilter(
                id = id, reference = reference, linkId = linkId
            ),
            page = page,
            sort = sort
        )
}
