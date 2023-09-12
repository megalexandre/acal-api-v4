package br.com.acalappv4.application.web.adapter

fun interface ResponseAdapter<in Entity, out T> {

    fun toResponse(entity: Entity): T

}