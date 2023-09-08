package br.com.acalappv4.resource.adapter

import br.com.acalappv4.domain.entity.Area
import br.com.acalappv4.resource.document.AreaDocument

class AreaAdapter {

    companion object: ResourceAdapter<AreaDocument, Area>{

        override fun toEntity(document: AreaDocument): Area = with(document){
            Area(
               id = id,
               name = name
            )
        }

        override fun toDocument(entity: Area): AreaDocument = with(entity) {
            AreaDocument(
                id = id,
                name = name
            )
        }
    }

}