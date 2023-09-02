package br.com.acalappv4.domain.entity

data class Address(
    val id: String,
    val area: Area,
    val number: Long,
    val letter: String,
    val hasHydrometer: Boolean,
)