package br.com.acalappv4.domain.dto.page

import br.com.acalappv4.domain.dto.list.HydrometerFilter

class HydrometerPageFilter(
    override val filter: HydrometerFilter? = null,
    override val page: Page? = null,
    override  val sort: Sort? = null,
): PageFilter(page, sort)