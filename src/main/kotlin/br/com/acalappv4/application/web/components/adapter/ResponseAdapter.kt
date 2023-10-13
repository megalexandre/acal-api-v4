package br.com.acalappv4.application.web.components.adapter

fun interface ResponseAdapter<in Entity, out T> {

    fun toResponse(entity: Entity): T

}