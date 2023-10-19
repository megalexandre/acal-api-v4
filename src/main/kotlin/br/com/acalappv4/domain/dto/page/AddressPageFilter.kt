package br.com.acalappv4.domain.dto.page

import br.com.acalappv4.domain.dto.list.AddressFilter

class AddressPageFilter(
    override val filter: AddressFilter? = null,
    override val page: Page? = null,
    override val sort: Sort? = null,
): PageFilter(page, sort)