package br.com.acalappv4.resource.event

import br.com.acalappv4.resource.document.DocumentItem
import org.springframework.context.ApplicationEvent

class UpdatedDocumentEvent(val name: String, val payload: DocumentItem): ApplicationEvent(name)
