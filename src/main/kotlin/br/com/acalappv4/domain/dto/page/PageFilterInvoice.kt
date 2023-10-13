package br.com.acalappv4.domain.dto.page

import br.com.acalappv4.domain.dto.list.LinkFilter

class PageFilterInvoice(
    val invoiceFilter: LinkFilter? = null,
    override val page: Page? = null,
    override val sort: Sort? = null,

    ): PageFilter(page, sort)
