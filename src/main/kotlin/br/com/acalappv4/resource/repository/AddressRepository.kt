package br.com.acalappv4.resource.repository

import br.com.acalappv4.resource.document.AddressDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface AddressRepository : MongoRepository<AddressDocument, String>{

    fun findByAreaId(id: String): List<AddressDocument>?

}