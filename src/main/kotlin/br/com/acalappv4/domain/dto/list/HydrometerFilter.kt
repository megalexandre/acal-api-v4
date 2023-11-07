package br.com.acalappv4.domain.dto.list

import br.com.acalappv4.domain.entity.Reference

class HydrometerFilter(
    val id: String? = null,
    val reference: Reference? = null,
    val addressId: String? = null,
    val area: AreaFilter? = null,
    val total: Long? = null,
): DefaultFilter


