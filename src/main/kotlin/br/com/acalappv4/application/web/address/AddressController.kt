package br.com.acalappv4.application.web.address

import br.com.acalappv4.application.web.address.request.CreateAddressRequest
import br.com.acalappv4.application.web.address.response.CreateAddressResponse
import br.com.acalappv4.domain.usecase.address.CreateAddressUsecase
import jakarta.validation.Valid
import java.net.URI
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.created
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("address", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
class AddressController(
    private val createAddress: CreateAddressUsecase
){

    @PostMapping
    fun create(@Valid @RequestBody request: CreateAddressRequest): ResponseEntity<CreateAddressResponse> =
        created(URI("POST/address")).body(
            CreateAddressResponse(createAddress.execute(request.toEntity())
        ))

}

