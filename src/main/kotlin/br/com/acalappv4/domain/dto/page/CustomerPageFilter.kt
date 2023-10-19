package br.com.acalappv4.domain.dto.page

import br.com.acalappv4.domain.dto.list.CustomerFilter

class CustomerPageFilter(
    override val filter: CustomerFilter? = null,
    override val page: Page? = null,
    override  val sort: Sort? = null,
): PageFilter(page, sort)