package br.com.acalappv4.resource.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "hydrometer")
data class HydrometerDocument(

    @Id
    val id: String,

    val actualCollect: HydrometerCollectDocument,

    val lastCollect: HydrometerCollectDocument,

) : DocumentItem


data class HydrometerCollectDocument(
    val reference: ReferenceDocument,
    val totalMeter: Long,
)
