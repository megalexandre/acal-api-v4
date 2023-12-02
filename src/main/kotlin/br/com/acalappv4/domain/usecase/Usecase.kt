package br.com.acalappv4.domain.usecase

fun interface Usecase<in Input, out Output> {
    fun execute(input: Input): Output

}