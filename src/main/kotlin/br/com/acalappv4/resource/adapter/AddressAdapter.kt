package br.com.acalappv4.resource.adapter

import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.resource.adapter.AreaAdapter.Companion.toDocument
import br.com.acalappv4.resource.adapter.AreaAdapter.Companion.toEntity
import br.com.acalappv4.resource.document.AddressDocument
import br.com.acalappv4.util.normalize
import org.springframework.data.domain.Page

class AddressAdapter {

    companion object: ResourceAdapter<AddressDocument, Address> {

        override fun toEntity(document: AddressDocument): Address  = with(document){
            Address(
                id = id,
                area = toEntity(area),
                number = number,
                letter = letter,
                hasHydrometer = hasHydrometer,
            )
        }
        override fun toDocument(entity: Address): AddressDocument = with(entity){ AddressDocument(
            id = id,
            area = toDocument(area),
            number = number.normalize(),
            letter = letter.normalize(),
            hasHydrometer = hasHydrometer
            )
        }
    }

}

fun Page<AddressDocument>.toAddress() = map { AddressAdapter.toEntity(it)  }