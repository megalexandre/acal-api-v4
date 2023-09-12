package br.com.acalappv4.resource.repository

import br.com.acalappv4.resource.document.AreaDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface AreaRepository : MongoRepository<AreaDocument, String>