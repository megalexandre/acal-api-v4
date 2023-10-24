package br.com.acalappv4.application.web.invoice

import br.com.acalappv4.application.web.invoice.request.InvoiceCreateRequest
import br.com.acalappv4.application.web.invoice.request.InvoicePageRequest
import br.com.acalappv4.application.web.invoice.response.InvoiceCreateResponse
import br.com.acalappv4.application.web.invoice.response.InvoicePageResponse
import br.com.acalappv4.application.web.invoice.response.toInvoicePageResponse
import br.com.acalappv4.domain.usecase.invoice.CreateInvoiceUsecase
import br.com.acalappv4.domain.usecase.invoice.PaginateInvoiceUsecase
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.created
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("invoice", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
class InvoiceController(
    private val create: CreateInvoiceUsecase,
    private val paginate: PaginateInvoiceUsecase,
){
    @PostMapping
    fun create(@Valid @RequestBody request: List<InvoiceCreateRequest>): ResponseEntity<List<InvoiceCreateResponse>> =
        created(URI("POST/invoice")).body(
            create.execute(request.map { it.toInvoice() }).map {InvoiceCreateResponse(it)  }
        )
    @PostMapping("paginate")
    fun paginate(@RequestBody invoicePageRequest: InvoicePageRequest): ResponseEntity<Page<InvoicePageResponse>> =
        ok(paginate.execute(invoicePageRequest.toEntity()).toInvoicePageResponse())


}