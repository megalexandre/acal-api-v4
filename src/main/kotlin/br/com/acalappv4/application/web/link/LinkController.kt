package br.com.acalappv4.application.web.link

import br.com.acalappv4.application.web.link.request.CreateLinkRequest
import br.com.acalappv4.application.web.link.request.PageFilterLinkRequest
import br.com.acalappv4.application.web.link.response.toLinkPageResponse
import br.com.acalappv4.domain.usecase.link.CreateLinkUsecase
import br.com.acalappv4.domain.usecase.link.FindAllLinkUsecase
import br.com.acalappv4.domain.usecase.link.PaginateLinkUsecase
import jakarta.validation.Valid
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity.created
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("link", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
class LinkController(
    private val create: CreateLinkUsecase,
    private val findAll: FindAllLinkUsecase,
    private val paginate: PaginateLinkUsecase,
) {

    @PostMapping
    fun create(@Valid @RequestBody request: CreateLinkRequest) =
        created(URI("POST/link")).body(create.execute(request.toEntity()))

    @PostMapping("/paginate")
    fun paginate(@RequestBody pageFilterRequest: PageFilterLinkRequest) =
        ok(paginate.execute(pageFilterRequest.toEntity()).toLinkPageResponse())

}

