package br.com.acalappv4.application.web.address

import br.com.acalappv4.application.web.address.request.AddressCreateRequest
import br.com.acalappv4.application.web.address.request.AddressPageFilterRequest
import br.com.acalappv4.application.web.address.request.AddressUpdateRequest
import br.com.acalappv4.application.web.address.response.AddressResponse
import br.com.acalappv4.application.web.address.response.AddressCreateResponse
import br.com.acalappv4.application.web.address.response.toAddressPageResponse
import br.com.acalappv4.application.web.address.response.toAddressResponse
import br.com.acalappv4.domain.usecase.address.*
import jakarta.validation.Valid
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.created
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("address", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
class AddressController(
    private val create: CreateAddressUsecase,
    private val update: UpdateAddressUsecase,
    private val findAll: FindAllAddressUsecase,
    private val findById: FindAddressByIdUsecase,
    private val delete: DeleteAddressUsecase,
    private val paginate: PaginateAddressUsecase,
){

    @PostMapping
    fun create(@Valid @RequestBody request: AddressCreateRequest): ResponseEntity<AddressCreateResponse> =
        created(URI("POST/address")).body(
            AddressCreateResponse(create.execute(request.toEntity())))

    @PutMapping
    fun update(@Valid @RequestBody request: AddressUpdateRequest) = ok(update.execute(request.toEntity()))

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String) = findById.execute(id)?.let { ok().body(AddressResponse(it)) }

    @GetMapping("/list")
    fun findAll() = ok().body(findAll.execute(Unit).toAddressResponse() )

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = ok(delete.execute(id.trim()))

    @PostMapping("/paginate")
    fun paginate(@RequestBody pageFilterRequest: AddressPageFilterRequest) =
        ok(paginate.execute(pageFilterRequest.toEntity()).toAddressPageResponse())
}

