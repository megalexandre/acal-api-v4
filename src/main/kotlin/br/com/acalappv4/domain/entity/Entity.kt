package br.com.acalappv4.domain.entity

import java.time.LocalDateTime

interface Entity {

    val id: String
    val active: Boolean

    val createdAt: LocalDateTime
    val updatedAt: LocalDateTime

}