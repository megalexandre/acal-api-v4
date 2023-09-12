package br.com.acalappv4.application.web.adapter

fun interface RequestAdapter<out T> {

    fun toEntity(): T

}