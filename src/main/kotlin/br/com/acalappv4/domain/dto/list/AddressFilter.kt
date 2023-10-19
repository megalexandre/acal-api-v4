package br.com.acalappv4.domain.dto.list

import br.com.acalappv4.domain.entity.Area

class AddressFilter(
    val id: String? = null,
    val area: Area? = null,
    val number: String? = null,
    val letter: String? = null,
    val hasHydrometer: Boolean?  = null,
): DefaultFilter