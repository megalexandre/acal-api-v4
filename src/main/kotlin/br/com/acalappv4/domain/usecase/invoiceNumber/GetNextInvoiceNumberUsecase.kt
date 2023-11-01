package br.com.acalappv4.domain.usecase.invoiceNumber

import br.com.acalappv4.domain.entity.InvoiceNumber
import br.com.acalappv4.domain.entity.Reference
import br.com.acalappv4.domain.usecase.Usecase
import br.com.acalappv4.resource.datasourceImpl.SequenceDataSourceImpl
import org.springframework.stereotype.Service
import java.time.Year

@Service
class GetNextInvoiceNumberUsecase(
    private val sequenceDataSourceImpl: SequenceDataSourceImpl
): Usecase<Reference, InvoiceNumber> {
    override fun execute(input: Reference): InvoiceNumber =
        InvoiceNumber(
            year = input.year,
            month = input.month,
            number = sequenceDataSourceImpl.getSequence(input),
        )


}