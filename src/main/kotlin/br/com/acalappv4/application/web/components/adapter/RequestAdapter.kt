package br.com.acalappv4.application.web.components.adapter

fun interface RequestAdapter<out T> {

    fun toEntity(): T

}