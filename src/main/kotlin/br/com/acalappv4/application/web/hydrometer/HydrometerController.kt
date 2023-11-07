package br.com.acalappv4.application.web.hydrometer

import br.com.acalappv4.application.web.hydrometer.request.HydrometerCreateRequest
import br.com.acalappv4.application.web.hydrometer.request.HydrometerPageRequest
import br.com.acalappv4.application.web.hydrometer.response.HydrometerCreateResponse
import br.com.acalappv4.application.web.hydrometer.response.HydrometerPageResponse
import br.com.acalappv4.domain.usecase.hydrometer.CreateHydrometerLotUsecase
import br.com.acalappv4.domain.usecase.hydrometer.CreateHydrometerUsecase
import br.com.acalappv4.domain.usecase.hydrometer.PaginateHydrometerUsecase
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
@RequestMapping("hydrometer", consumes = [APPLICATION_JSON_VALUE], produces=[APPLICATION_JSON_VALUE])
class HydrometerController(
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

    @PostMapping("paginate")
    fun paginate(@RequestBody request: HydrometerPageRequest): ResponseEntity<Page<HydrometerPageResponse>> =
        ok(paginate.execute(request.toEntity()).map { HydrometerPageResponse(it) })

}

