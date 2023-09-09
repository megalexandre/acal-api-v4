package br.com.acalappv4.application.adapter

fun interface ApplicationAdapter<in Request, out T> {

    fun toEntity(request: Request): T

}