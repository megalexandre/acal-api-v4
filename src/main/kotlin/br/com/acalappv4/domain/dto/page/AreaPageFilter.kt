package br.com.acalappv4.domain.dto.page

import br.com.acalappv4.domain.dto.list.AreaFilter

class AreaPageFilter(
    override val filter: AreaFilter? = null,
    override val page: Page? = null,
    override  val sort: Sort? = null,
): PageFilter(page, sort)