package br.com.acalappv4.resource.datasourceImpl

import br.com.acalappv4.domain.datasource.SequenceDataSource
import br.com.acalappv4.resource.document.SequenceDocument
import br.com.acalappv4.resource.repository.SequenceRepository
import org.springframework.stereotype.Service
import java.time.Year

@Service
class SequenceDataSourceImpl(
    private val repository: SequenceRepository,
): SequenceDataSource {
    override fun getSequence(year: Year): String {

        val sequence = repository.findById(year.toString()).orElseGet { SequenceDocument(id = year.toString(), value = 1) }

        repository.save(sequence.copy(value = sequence.value+1 ))

        return "${sequence.id}/${sequence.value.toString().padStart(6, '0')}"
    }
}