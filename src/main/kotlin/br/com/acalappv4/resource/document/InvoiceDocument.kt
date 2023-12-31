package br.com.acalappv4.resource.document

import br.com.acalappv4.common.enums.Reason
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime

@Document(collection = "invoice")
data class InvoiceDocument (

    @Id
    val id: String,

    val reference: ReferenceDocument,

    val invoiceNumberDocument: InvoiceNumberDocument,

    val emission: LocalDateTime,

    val dueDate: LocalDateTime,

    val linkDetail: LinkDetailDocument,

    val invoiceDetails: List<InvoiceDetailDocument>,
)

data class InvoiceNumberDocument(
    val year: Int,
    val month: Int,
    val number: String,
    val value: String,
)

data class LinkDetailDocument(
    val linkId: String,
    val customer: String,
    val address: String,
    val customerNormalizedName: String,
    val addressNormalizedName: String,
)

data class InvoiceDetailDocument(
    val reason: Reason,
    val value: BigDecimal,
    val dataPaid: LocalDateTime?,
)
