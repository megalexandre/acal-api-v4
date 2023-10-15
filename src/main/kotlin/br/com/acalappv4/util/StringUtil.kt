package br.com.acalappv4.util

import java.text.Normalizer.Form.NFD
import java.text.Normalizer.normalize

fun String.normalize(): String =
    normalize(this, NFD).replace("[^\\p{ASCII}]".toRegex(), "")
        .trim()
        .lowercase()

