package br.com.acalappv4.application.web.address

import br.com.acalappv4.application.web.address.request.CreateAddressRequest
import br.com.acalappv4.application.web.address.request.PageFilterAddressRequest
import br.com.acalappv4.application.web.address.request.UpdateAddressRequest
import br.com.acalappv4.application.web.address.response.AddressResponse
import br.com.acalappv4.application.web.address.response.CreateAddressResponse
import br.com.acalappv4.application.web.address.response.toAddressPageResponse
import br.com.acalappv4.domain.usecase.address.CreateAddressUsecase
import br.com.acalappv4.domain.usecase.address.DeleteAddressUsecase
import br.com.acalappv4.domain.usecase.address.FindAddressByIdUsecase
import br.com.acalappv4.domain.usecase.address.FindAllAddressUsecase
import br.com.acalappv4.domain.usecase.address.PaginateAddressUsecase
import br.com.acalappv4.domain.usecase.address.UpdateAddressUsecase
import jakarta.validation.Valid
import java.net.URI
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.created
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
    fun create(@Valid @RequestBody request: CreateAddressRequest): ResponseEntity<CreateAddressResponse> =
        created(URI("POST/address")).body(
            CreateAddressResponse(create.execute(request.toEntity())))

    @PutMapping
    fun update(@Valid @RequestBody request: UpdateAddressRequest) = ok(update.execute(request.toEntity()))

    @GetMapping
    fun paginate() = ok(findAll.execute(Unit).map { AddressResponse(it) })

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String) =
        findById.execute(id)?.let { ok().body(AddressResponse(it)) }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = ok(delete.execute(id.trim()))

    @GetMapping("/paginate")
    fun paginate(@RequestBody pageFilterRequest: PageFilterAddressRequest) =
        ok(paginate.execute(pageFilterRequest.toEntity()).toAddressPageResponse())
}

