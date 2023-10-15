package br.com.acalappv4.util

import java.time.Month

fun Month.asReference(): String =
    this.value.toString().padStart(2,'0')

