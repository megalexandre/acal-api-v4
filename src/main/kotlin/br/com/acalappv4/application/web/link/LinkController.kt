package br.com.acalappv4.application.web.link

import br.com.acalappv4.application.web.customer.adapter.CustomerPageAdapter
import br.com.acalappv4.application.web.customer.adapter.toCustomerPage
import br.com.acalappv4.application.web.customer.request.CustomerPageRequest
import br.com.acalappv4.application.web.link.request.CreateLinkRequest
import br.com.acalappv4.domain.usecase.link.CreateLinkUsecase
import br.com.acalappv4.domain.usecase.link.FindAllLinkUsecase
import jakarta.validation.Valid
import java.net.URI
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.created
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("link", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
class LinkController(
    private val create: CreateLinkUsecase,
    private val findAll: FindAllLinkUsecase,
) {

    @PostMapping
    fun create(@Valid @RequestBody request: CreateLinkRequest) =
        created(URI("POST/link")).body(create.execute(request.toEntity()))

    @GetMapping
    fun paginate() =
        ResponseEntity.ok(findAll.execute(Unit))
}

