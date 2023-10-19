package br.com.acalappv4.domain.dto.page

import br.com.acalappv4.domain.dto.list.CategoryFilter

class CategoryPageFilter(
    override val filter: CategoryFilter? = null,
    override val page: Page? = null,
    override val sort: Sort? = null,
): PageFilter(page, sort)