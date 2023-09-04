package br.com.acalappv4.resource.repository

import br.com.acalappv4.domain.entity.DocumentNumber
import br.com.acalappv4.resource.document.CustomerItem
import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository : MongoRepository<CustomerItem, String> {

    fun existsCustomerByDocumentNumber(documentNumber: DocumentNumber): Boolean
}