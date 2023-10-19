package br.com.acalappv4.domain.dto.page

import br.com.acalappv4.domain.dto.list.LinkFilter

class LinkPageFilter(
    val linkFilter: LinkFilter? = null,
    override val page: Page? = null,
    override val sort: Sort? = null,
): PageFilter(page, sort)
