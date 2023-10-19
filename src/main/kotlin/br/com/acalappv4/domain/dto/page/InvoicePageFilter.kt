package br.com.acalappv4.domain.dto.page

import br.com.acalappv4.domain.dto.list.InvoiceFilter

class InvoicePageFilter(
    override val filter: InvoiceFilter? = null,
    override val page: Page? = null,
    override val sort: Sort? = null,
): PageFilter(page, sort)