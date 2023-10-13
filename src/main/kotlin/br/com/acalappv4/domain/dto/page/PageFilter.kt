package br.com.acalappv4.domain.dto.page

import br.com.acalappv4.domain.dto.list.LinkFilter

open class PageFilter (
    open val page: Page? = null,
    open val sort: Sort? = null,
    open val filter: LinkFilter? = null,
)

