package br.com.acalappv4.domain.entity

data class Address(
    val id: String,
    val area: Area,
    val number: String,
    val letter: String,
    val hasHydrometer: Boolean,
): Entity