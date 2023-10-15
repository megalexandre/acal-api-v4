package br.com.acalappv4.domain.usecase.invoiceNumber

import br.com.acalappv4.domain.usecase.Usecase
import br.com.acalappv4.resource.datasourceImpl.SequenceDataSourceImpl
import org.springframework.stereotype.Service
import java.time.Year

@Service
class GetNextInvoiceNumberUsecase(
    private val sequenceDataSourceImpl: SequenceDataSourceImpl
): Usecase<Year, String> {
    override fun execute(input: Year): String = sequenceDataSourceImpl.getSequence(input)
}