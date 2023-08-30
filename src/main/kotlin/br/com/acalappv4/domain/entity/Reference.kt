package br.com.acalappv4.domain.entity

class Reference(
    private val month: String,
    private val year: String
) {

    val value: String
        get() = "${month.padStart(2,'0')}${year.padStart(4,'0')}"

}




