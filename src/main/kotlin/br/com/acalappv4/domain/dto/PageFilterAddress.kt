package br.com.acalappv4.domain.dto

import br.com.acalappv4.domain.entity.Area

class PageFilterAddress(
    val id: String? = null,
    val area: Area? = null,
    val number: String? = null,
    val letter: String? = null,
    val hasHydrometer: Boolean?  = null,

    val page: Page? = null,
    val sort: Sort? = null,
)