package br.com.acalappv4.application.web.hydrometer

import br.com.acalappv4.application.web.hydrometer.request.HydrometerCreateRequest
import br.com.acalappv4.application.web.hydrometer.request.HydrometerPageRequest
import br.com.acalappv4.application.web.hydrometer.response.HydrometerCreateResponse
import br.com.acalappv4.application.web.hydrometer.response.HydrometerPageResponse
import br.com.acalappv4.application.web.hydrometer.response.HydrometerResponse
import br.com.acalappv4.domain.usecase.hydrometer.*
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.created
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("hydrometer", consumes = [APPLICATION_JSON_VALUE], produces=[APPLICATION_JSON_VALUE])
class HydrometerController(
    private val findById: FindHydrometerByIdUsecase,
    private val delete: DeleteHydrometerUsecase,
    private val create: CreateHydrometerUsecase,
    private val createLot: CreateHydrometerLotUsecase,
    private val paginate: PaginateHydrometerUsecase,
    ){

    @PostMapping("/all")
    fun createLot(@Valid @RequestBody request: List<HydrometerCreateRequest>): ResponseEntity<List<HydrometerCreateResponse>> =
        created(URI("POST/hydrometer"))
            .body(createLot.execute(request.map { it.toHydrometer() }).map { HydrometerCreateResponse(it) })

    @PostMapping
    fun create(@Valid @RequestBody request: HydrometerCreateRequest): ResponseEntity<HydrometerCreateResponse> =
        created(URI("POST/hydrometer"))
            .body(HydrometerCreateResponse(create.execute(request.toHydrometer())))

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String) =
        findById.execute(id)?.let { ok().body( HydrometerResponse(it)) } ?: ResponseEntity.noContent()

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = ok(delete.execute(id))

    @PostMapping("paginate")
    fun paginate(@RequestBody request: HydrometerPageRequest): ResponseEntity<Page<HydrometerPageResponse>> =
        ok(paginate.execute(request.toEntity()).map { HydrometerPageResponse(it) })

}

