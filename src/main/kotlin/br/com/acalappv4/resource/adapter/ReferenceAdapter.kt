package br.com.acalappv4.resource.adapter

import br.com.acalappv4.domain.entity.Reference
import br.com.acalappv4.resource.document.ReferenceDocument
import java.time.Month
import java.time.Year

class ReferenceAdapter{

    companion object: ResourceAdapter<ReferenceDocument, Reference> {
        override fun toDocument(entity: Reference): ReferenceDocument = with(entity){
            ReferenceDocument(
                year = entity.year.value,
                month = entity.month.value,
            )
        }

        override fun toEntity(document: ReferenceDocument): Reference = with(document){
            Reference(
                year = Year.of(document.year),
                month = Month.of(document.month),
            )
        }
    }
}
