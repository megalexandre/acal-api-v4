package br.com.acalappv4.resource.repository

import br.com.acalappv4.resource.document.SequenceDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface SequenceRepository : MongoRepository<SequenceDocument, String>