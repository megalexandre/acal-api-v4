package br.com.acalappv4.resource.adapter

import br.com.acalappv4.domain.entity.HydrometerCollect
import br.com.acalappv4.resource.adapter.ReferenceAdapter.Companion.toEntity
import br.com.acalappv4.resource.document.HydrometerCollectDocument

class HydrometerCollectAdapter{
    companion object: ResourceAdapter<HydrometerCollectDocument, HydrometerCollect>{
        override fun toEntity(document: HydrometerCollectDocument): HydrometerCollect = with(document){
            HydrometerCollect(
                reference = toEntity(reference),
                totalMeter = totalMeter,
            )
        }

        override fun toDocument(entity: HydrometerCollect): HydrometerCollectDocument = with(entity) {
            HydrometerCollectDocument(
                reference = ReferenceAdapter.toDocument(reference),
                totalMeter = totalMeter,
            )
        }
    }
}
