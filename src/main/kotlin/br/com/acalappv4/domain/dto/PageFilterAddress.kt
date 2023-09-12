package br.com.acalappv4.domain.dto

import br.com.acalappv4.domain.entity.Area

class PageFilterAddress(
    val id: String?,
    val area: Area,
    val number: Long,
    val letter: String,
    val hasHydrometer: Boolean,
    val page: Page?,
    val sort: Sort?,
)