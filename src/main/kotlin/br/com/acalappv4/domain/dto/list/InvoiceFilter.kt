package br.com.acalappv4.domain.dto.list

import br.com.acalappv4.domain.entity.*

class InvoiceFilter(
    val id: String? = null,
    val link: Link? = null,
    val reference: Reference? = null,
): DefaultFilter()