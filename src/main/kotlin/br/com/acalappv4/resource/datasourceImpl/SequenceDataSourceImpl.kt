package br.com.acalappv4.resource.datasourceImpl

import br.com.acalappv4.domain.datasource.SequenceDataSource
import br.com.acalappv4.domain.entity.Reference
import br.com.acalappv4.resource.document.SequenceDocument
import br.com.acalappv4.resource.repository.SequenceRepository
import org.springframework.stereotype.Service

@Service
class SequenceDataSourceImpl(
    private val repository: SequenceRepository,
): SequenceDataSource {
    override fun getSequence(input: Reference): String {
        val sequence = repository.findById(input.value).orElseGet { SequenceDocument(input.value, value = 1) }
        repository.save(sequence.copy(value = sequence.value+1 ))

        return sequence.value.toString().padStart(6, '0')
    }
}