package br.com.acalappv4.domain.datasource

import br.com.acalappv4.domain.entity.Reference

interface SequenceDataSource {
    fun getSequence(reference: Reference): String

}