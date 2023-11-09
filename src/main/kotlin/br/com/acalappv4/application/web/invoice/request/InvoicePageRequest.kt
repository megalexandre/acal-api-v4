package br.com.acalappv4.application.web.invoice.request

import br.com.acalappv4.domain.dto.list.InvoiceFilter
import br.com.acalappv4.domain.dto.page.InvoicePageFilter
import br.com.acalappv4.domain.dto.page.Page
import br.com.acalappv4.domain.dto.page.Sort
import br.com.acalappv4.domain.entity.Reference
import java.time.LocalDateTime

class InvoicePageRequest(
    val id: String?,
    val reference: Reference?,
    val customerName: String?,
    val addressName: String?,
    val linkId: String?,
    val dueDate: LocalDateTime?,
    val page: Page?,
    val sort: Sort?,
){
    fun toEntity(): InvoicePageFilter =
        InvoicePageFilter(
            filter = InvoiceFilter(
                id = id,
                customerName = customerName,
                addressName = addressName,
                dueDate = dueDate,
                reference = reference,
                linkId = linkId
            ),
            page = page,
            sort = sort
        )
}
