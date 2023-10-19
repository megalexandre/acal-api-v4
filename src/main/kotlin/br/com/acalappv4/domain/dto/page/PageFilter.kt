package br.com.acalappv4.domain.dto.page

import br.com.acalappv4.domain.dto.list.DefaultFilter

open class PageFilter (
    open val page: Page? = null,
    open val sort: Sort? = null,
    open val filter: DefaultFilter? = null,
)

