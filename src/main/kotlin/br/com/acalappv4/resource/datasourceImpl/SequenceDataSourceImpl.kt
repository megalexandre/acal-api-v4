package br.com.acalappv4.resource.datasourceImpl

import br.com.acalappv4.domain.datasource.SequenceDataSource
import br.com.acalappv4.domain.entity.Reference
import br.com.acalappv4.resource.document.SequenceDocument
import br.com.acalappv4.resource.document.increment
import br.com.acalappv4.resource.document.valueString
import br.com.acalappv4.resource.repository.SequenceRepository
import org.springframework.stereotype.Service

@Service
class SequenceDataSourceImpl(
    private val repository: SequenceRepository,
): SequenceDataSource {
    override fun getSequence(reference: Reference): String =
       repository.findById(reference.value).orElseGet {
            SequenceDocument(reference.value, value = 1)
        }.also {
            repository.save(it.increment())
        }.valueString
}