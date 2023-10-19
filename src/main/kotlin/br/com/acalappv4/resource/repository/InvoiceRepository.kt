package br.com.acalappv4.resource.repository

import br.com.acalappv4.resource.document.InvoiceDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface InvoiceRepository : MongoRepository<InvoiceDocument, String>