package br.com.acalappv4.resource.repository

import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.resource.document.LinkDocument
import java.util.Optional
import org.springframework.data.mongodb.repository.MongoRepository

interface LinkRepository : MongoRepository<LinkDocument, String> {

    fun findByAddressAndActive(address: Address, active: Boolean): Optional<LinkDocument>?

}