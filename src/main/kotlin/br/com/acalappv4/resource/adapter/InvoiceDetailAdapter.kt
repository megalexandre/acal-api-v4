package br.com.acalappv4.resource.adapter

import br.com.acalappv4.domain.entity.InvoiceDetail
import br.com.acalappv4.resource.document.InvoiceDetailDocument

class InvoiceDetailAdapter{

    companion object: ResourceAdapter<InvoiceDetailDocument, InvoiceDetail> {
        override fun toDocument(entity: InvoiceDetail): InvoiceDetailDocument = with(entity){
            InvoiceDetailDocument(
                reason = reason,
                value = value,
                dataPaid = dataPaid,
            )
        }

        override fun toEntity(document: InvoiceDetailDocument): InvoiceDetail = with(document){
            InvoiceDetail(
                reason = reason,
                value = value,
                dataPaid = dataPaid,
            )
        }
    }

}
