package br.com.acalappv4.resource.adapter

import br.com.acalappv4.domain.entity.Hydrometer
import br.com.acalappv4.resource.adapter.AddressAdapter.Companion.toEntity
import br.com.acalappv4.resource.adapter.HydrometerAdapter.Companion.toEntity
import br.com.acalappv4.resource.adapter.HydrometerCollectAdapter.Companion.toDocument
import br.com.acalappv4.resource.adapter.HydrometerCollectAdapter.Companion.toEntity
import br.com.acalappv4.resource.document.HydrometerDocument
import org.springframework.data.domain.Page

class HydrometerAdapter{
    companion object: ResourceAdapter<HydrometerDocument, Hydrometer>{
        override fun toEntity(document: HydrometerDocument): Hydrometer = with(document){
            Hydrometer(
               id = id,
               address = toEntity(document.address),
               actualCollect = toEntity(actualCollect),
               lastCollect = toEntity(lastCollect),
            )
        }

        override fun toDocument(entity: Hydrometer): HydrometerDocument = with(entity) {
            HydrometerDocument(
                id = id,
                address = AddressAdapter.toDocument(address),
                actualCollect = toDocument(actualCollect),
                lastCollect = toDocument(lastCollect),
            )
        }
    }
}

fun Page<HydrometerDocument>.toHydrometer() = map { toEntity(it)  }
fun List<HydrometerDocument>.toHydrometer() = map { toEntity(it)  }