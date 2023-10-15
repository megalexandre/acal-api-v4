package br.com.acalappv4.domain.datasource

import java.time.Year

interface SequenceDataSource {

    fun getSequence(year: Year): String

}