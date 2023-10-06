package br.com.acalappv4.resource.repository

import br.com.acalappv4.resource.document.LinkDocument
import java.util.Optional
import org.springframework.data.mongodb.repository.MongoRepository

interface LinkRepository : MongoRepository<LinkDocument, String> {

    fun findByAddressIdAndActive(addressId: String, active: Boolean): Optional<LinkDocument>?

    fun findByAddressId(id: String): List<LinkDocument>?

    fun findByAddressMailId(id: String): List<LinkDocument>?

    fun findByCustomerId(id: String): List<LinkDocument>?

}