package br.com.acalappv4.util

import java.math.BigDecimal
import java.math.RoundingMode
import java.math.RoundingMode.HALF_UP
import java.text.Normalizer.Form.NFD
import java.text.Normalizer.normalize

fun BigDecimal.toCurrency(): BigDecimal =
    this.setScale(2, HALF_UP)