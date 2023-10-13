package br.com.acalappv4.resource.adapter

import br.com.acalappv4.domain.entity.Link
import br.com.acalappv4.resource.adapter.AddressAdapter.Companion.toDocument
import br.com.acalappv4.resource.adapter.AddressAdapter.Companion.toEntity
import br.com.acalappv4.resource.document.CategoryDocument
import br.com.acalappv4.resource.document.LinkDocument
import org.springframework.data.domain.Page

class LinkAdapter{

    companion object: ResourceAdapter<LinkDocument, Link> {
        override fun toDocument(entity: Link): LinkDocument = with(entity){
            LinkDocument(
                id = id,
                customer = CustomerAdapter.toDocument(customer) ,
                active = active,
                address = toDocument(address),
                addressMail = toDocument(addressMail),
                startedAt = startedAt,
                finishedAt = finishedAt,
                category = CategoryAdapter.toDocument(category),
                createdBy = createdBy,
            )
        }

        override fun toEntity(document: LinkDocument): Link = with(document){
            Link(
                id = id,
                customer = CustomerAdapter.toEntity(customer),
                active = active,
                startedAt = startedAt,
                finishedAt = finishedAt,
                createdBy = createdBy,
                address = toEntity(address),
                addressMail = toEntity(addressMail),
                category = CategoryAdapter.toEntity(category),
                invoices = listOf(),
            )
        }
    }

}

fun Page<LinkDocument>.toLink() = map { LinkAdapter.toEntity(it)  }
fun List<LinkDocument>.toLink() = map { LinkAdapter.toEntity(it)  }