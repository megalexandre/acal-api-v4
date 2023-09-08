package br.com.acalappv4.resource.adapter

interface ResourceAdapter<DocumentItem, Entity> {

    fun toEntity(document: DocumentItem): Entity

    fun toDocument(entity: Entity): DocumentItem

}