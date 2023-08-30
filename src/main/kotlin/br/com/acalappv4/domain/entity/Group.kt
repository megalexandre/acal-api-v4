package br.com.acalappv4.domain.entity

import java.time.LocalDateTime

class Group(

    override val id: String,
    override val active: Boolean,
    override val createdAt: LocalDateTime,
    override val updatedAt: LocalDateTime

) : Entity {
}