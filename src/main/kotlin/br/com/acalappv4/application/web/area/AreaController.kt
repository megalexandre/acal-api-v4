package br.com.acalappv4.application.web.area

import br.com.acalappv4.application.web.area.request.AreaCreateRequest
import br.com.acalappv4.application.web.area.request.AreaPageFilterRequest
import br.com.acalappv4.application.web.area.request.AreaUpdateRequest
import br.com.acalappv4.application.web.area.response.AreaResponse
import br.com.acalappv4.application.web.area.response.CreateAreaResponse
import br.com.acalappv4.application.web.area.response.toAreaPageResponse
import br.com.acalappv4.application.web.area.response.toAreaResponse
import br.com.acalappv4.domain.usecase.area.*
import jakarta.validation.Valid
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.created
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*
import java.net.URI

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
    fun create(@Valid @RequestBody request: AreaCreateRequest): ResponseEntity<CreateAreaResponse> =
        created(URI("POST/category")).body(CreateAreaResponse(create.execute(request.toEntity())))

    @GetMapping
    fun paginate() = ok(findAll.execute(Unit).map { AreaResponse(it) })

    @GetMapping("/list")
    fun findAll() = ok().body(findAll.execute(Unit).toAreaResponse() )

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String) =
        findById.execute(id)?.let { ok().body(AreaResponse(it)) }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = ok(delete.execute(id.trim()))

    @PostMapping("/paginate")
    fun paginate(@RequestBody pageFilterRequest: AreaPageFilterRequest) =
        ok(paginate.execute(pageFilterRequest.toEntity()).toAreaPageResponse())

    @PutMapping
    fun create(@Valid @RequestBody request: AreaUpdateRequest) = ok(update.execute(request.toEntity()))
}

