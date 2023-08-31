package br.com.acalappv4.domain.entity

class Reference(
    private val year: String,
    private val month: String
) {

    val value: String
        get() = "${month.padStart(2,'0')}${year.padStart(4,'0')}"

}




