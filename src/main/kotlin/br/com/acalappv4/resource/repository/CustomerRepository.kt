package br.com.acalappv4.resource.repository

import br.com.acalappv4.resource.document.CustomerItem
import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository : MongoRepository<CustomerItem, String> {

    fun existsByDocumentNumberNumber(number : String): Boolean

    fun findByDocumentNumberNumber(number : String): CustomerItem?

}