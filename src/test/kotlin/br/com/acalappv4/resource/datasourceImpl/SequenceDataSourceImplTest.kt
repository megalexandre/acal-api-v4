package br.com.acalappv4.resource.datasourceImpl

import br.com.acalappv4.resource.document.SequenceDocument
import br.com.acalappv4.resource.repository.SequenceRepository
import br.com.acalappv4.util.toReference
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.util.Optional.empty
import java.util.Optional.of

class SequenceDataSourceImplTest{

    private val repository = mockk<SequenceRepository>()

    private val sequenceDataSource = SequenceDataSourceImpl(
        repository = repository
    )

    @Test
    fun `when does not exist sequence should create and return 1`(){
        val reference = LocalDate.now().toReference()
        val savedSequenceDocument = slot<SequenceDocument>()
        val sequenceDocument = SequenceDocument(id = reference.value, 1)

        every {
            repository.findById(reference.value)
        } returns empty()

        every {
            repository.save(capture(savedSequenceDocument))
        } returns sequenceDocument

        val sequence = sequenceDataSource.getSequence(reference)

        assertEquals(sequence, "000001")

        with(savedSequenceDocument.captured){
            assertEquals("12/2023",this.id)
            assertEquals(2,this.value)
        }
    }


    @Test
    fun `when sequence exits should do not create and return value + 1`(){
        val reference = LocalDate.now().toReference()
        val savedSequenceDocument = slot<SequenceDocument>()
        val sequenceDocument = SequenceDocument(id = reference.value, 10)

        every {
            repository.findById(reference.value)
        } returns of(sequenceDocument)

        every {
            repository.save(capture(savedSequenceDocument))
        } returns sequenceDocument

        val sequence = sequenceDataSource.getSequence(reference)

        assertEquals(sequence, "000010")

        with(savedSequenceDocument.captured){
            assertEquals("12/2023",this.id)
            assertEquals(11,this.value)
        }
    }

}