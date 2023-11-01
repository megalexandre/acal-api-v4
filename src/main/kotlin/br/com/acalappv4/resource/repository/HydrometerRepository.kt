package br.com.acalappv4.resource.repository

import br.com.acalappv4.resource.document.HydrometerDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface HydrometerRepository : MongoRepository<HydrometerDocument, String>