package br.com.acalappv4.application.web.area

import br.com.acalappv4.application.web.area.request.CreateAreaRequest
import br.com.acalappv4.application.web.area.request.PageFilterAreaRequest
import br.com.acalappv4.application.web.area.request.UpdateAreaRequest
import br.com.acalappv4.application.web.area.response.AreaResponse
import br.com.acalappv4.application.web.area.response.CreateAreaResponse
import br.com.acalappv4.application.web.area.response.toAreaPageResponse
import br.com.acalappv4.domain.usecase.area.CreateAreaUsecase
import br.com.acalappv4.domain.usecase.area.DeleteAreaUsecase
import br.com.acalappv4.domain.usecase.area.FindAllAreaUsecase
import br.com.acalappv4.domain.usecase.area.FindAreaByIdUsecase
import br.com.acalappv4.domain.usecase.area.PaginateAreaUsecase
import br.com.acalappv4.domain.usecase.area.UpdateAreaUsecase
import jakarta.validation.Valid
import java.net.URI
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("area", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
class AreaController(
    private val create: CreateAreaUsecase,
    private val findById: FindAreaByIdUsecase,
    private val findAll: FindAllAreaUsecase,
    private val delete: DeleteAreaUsecase,
    private val paginate: PaginateAreaUsecase,
    private val update: UpdateAreaUsecase
) {

    @PostMapping
    fun create(@Valid @RequestBody request: CreateAreaRequest): ResponseEntity<CreateAreaResponse> =
        created(URI("POST/category")).body(CreateAreaResponse(create.execute(request.toEntity())))

    @GetMapping
    fun paginate() = ok(findAll.execute(Unit).map { AreaResponse(it) })

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String) =
        findById.execute(id)?.let { ok().body(AreaResponse(it)) }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = ok(delete.execute(id.trim()))

    @GetMapping("/paginate")
    fun paginate(@RequestBody pageFilterRequest: PageFilterAreaRequest) =
        ok(paginate.execute(pageFilterRequest.toEntity()).toAreaPageResponse())

    @PutMapping
    fun create(@Valid @RequestBody request: UpdateAreaRequest) = ok(update.execute(request.toEntity()))
}

