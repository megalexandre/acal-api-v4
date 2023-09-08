package br.com.acalappv4.resource.repository

import br.com.acalappv4.resource.document.CustomerDocument
import java.util.Optional
import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository : MongoRepository<CustomerDocument, String> {

    fun existsByDocumentNumberNumber(number : String): Boolean

    fun findByDocumentNumberNumber(number : String): Optional<CustomerDocument>

}