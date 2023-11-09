package br.com.acalappv4.resource.adapter

import br.com.acalappv4.domain.entity.Invoice
import br.com.acalappv4.domain.entity.InvoiceNumber
import br.com.acalappv4.domain.entity.LinkDetail
import br.com.acalappv4.domain.entity.valueNormalized
import br.com.acalappv4.resource.document.InvoiceDocument
import br.com.acalappv4.resource.document.InvoiceNumberDocument
import br.com.acalappv4.resource.document.LinkDetailDocument
import br.com.acalappv4.util.normalize
import org.springframework.data.domain.Page
import java.time.Month
import java.time.Year

class InvoiceAdapter{
    companion object: ResourceAdapter<InvoiceDocument, Invoice> {
        override fun toDocument(entity: Invoice): InvoiceDocument = with(entity){
            InvoiceDocument(
                id = id,
                reference = ReferenceAdapter.toDocument(entity.reference),
                emission = emission,
                dueDate = dueDate,
                linkDetail = LinkDetailAdapter.toDocument(linkDetail),
                invoiceNumberDocument = InvoiceNumberDocumentAdapter.toDocument(entity.invoiceNumber),
                invoiceDetails = invoiceDetails.map { InvoiceDetailAdapter.toDocument(it) },
            )
        }

        override fun toEntity(document: InvoiceDocument): Invoice = with(document){
            Invoice(
                id = id,
                reference = ReferenceAdapter.toEntity(document.reference),
                emission = emission,
                dueDate = dueDate,
                linkDetail = LinkDetailAdapter.toEntity(linkDetail),
                invoiceNumber =  InvoiceNumberDocumentAdapter.toEntity(document.invoiceNumberDocument),
                invoiceDetails = invoiceDetails.map { InvoiceDetailAdapter.toEntity(it)} ,
            )
        }
    }

}

class InvoiceNumberDocumentAdapter {
    companion object: ResourceAdapter<InvoiceNumberDocument, InvoiceNumber>{
        override fun toEntity(document: InvoiceNumberDocument): InvoiceNumber =
            InvoiceNumber(
                year = Year.of(document.year),
                month = Month.of(document.month),
                number = document.number
            )
        override fun toDocument(entity: InvoiceNumber): InvoiceNumberDocument =
            InvoiceNumberDocument(
                year = entity.year.value,
                month = entity.month.value,
                number = entity.number,
                value = entity.valueNormalized,
            )
    }
}



class LinkDetailAdapter {
    companion object: ResourceAdapter<LinkDetailDocument, LinkDetail> {
        override fun toDocument(entity: LinkDetail): LinkDetailDocument = with(entity){
            LinkDetailDocument(
                linkId = entity.linkId,

                address = entity.address,
                addressNormalizedName = entity.address.normalize(),

                customer = entity.customer,
                customerNormalizedName = entity.customer.normalize(),
            )
        }

        override fun toEntity(document: LinkDetailDocument): LinkDetail = with(document){
            LinkDetail(
                linkId = document.linkId,
                address = document.address,
                customer = document.customer,
            )
        }
    }
}

fun Page<InvoiceDocument>.toInvoice() = map { InvoiceAdapter.toEntity(it)  }
fun List<InvoiceDocument>.toInvoice() = map { InvoiceAdapter.toEntity(it)  }