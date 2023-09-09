package br.com.acalappv4.domain.dto

import org.springframework.data.domain.Sort

class Sort (
    val field: String?,
    val direction: Sort.Direction?,
)
