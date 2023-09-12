package br.com.acalappv4.application.adapter

fun interface RequestAdapter<out T> {

    fun toEntity(): T

}