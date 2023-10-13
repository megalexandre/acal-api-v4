package br.com.acalappv4.domain.dto.page

import br.com.acalappv4.domain.entity.Area

class PageFilterAddress(
    val id: String? = null,
    val area: Area? = null,
    val number: String? = null,
    val letter: String? = null,
    val hasHydrometer: Boolean?  = null,

    override val page: Page? = null,
    override val sort: Sort? = null,

    ): PageFilter(page, sort)