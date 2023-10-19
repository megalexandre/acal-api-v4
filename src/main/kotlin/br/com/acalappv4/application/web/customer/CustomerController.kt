package br.com.acalappv4.application.web.customer

import br.com.acalappv4.application.web.customer.request.CustomerCreateRequest
import br.com.acalappv4.application.web.customer.request.CustomerPageRequest
import br.com.acalappv4.application.web.customer.request.UpdateCustomerRequest
import br.com.acalappv4.application.web.customer.response.CreateCustomerResponse
import br.com.acalappv4.application.web.customer.response.CustomerPageResponse
import br.com.acalappv4.application.web.customer.response.CustomerResponse
import br.com.acalappv4.domain.usecase.customer.CreateCustomerUsecase
import br.com.acalappv4.domain.usecase.customer.CreateCustomerLotUsecase
import br.com.acalappv4.domain.usecase.customer.DeleteCustomerUsecase
import br.com.acalappv4.domain.usecase.customer.FindCustomerByIdUsecase
import br.com.acalappv4.domain.usecase.customer.PaginateCustomerUsecase
import br.com.acalappv4.domain.usecase.customer.UpdateCustomerUsecase
import jakarta.validation.Valid
import java.net.URI
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
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
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customer", consumes = [APPLICATION_JSON_VALUE], produces=[APPLICATION_JSON_VALUE])
class CustomerController(
    private val delete: DeleteCustomerUsecase,
    private val create: CreateCustomerUsecase,
    private val createLot: CreateCustomerLotUsecase,
    private val update: UpdateCustomerUsecase,
    private val findById: FindCustomerByIdUsecase,
    private val paginate: PaginateCustomerUsecase,
    ){

    @PostMapping
    fun create(@Valid @RequestBody request: CustomerCreateRequest): ResponseEntity<CreateCustomerResponse> =
        created(URI("POST/customer")).body(CreateCustomerResponse(create.execute(request.toCustomer())))

    @PutMapping
    fun update(@Valid @RequestBody request: UpdateCustomerRequest): ResponseEntity<CreateCustomerResponse> =
        ok(CreateCustomerResponse(update.execute(request.toEntity())))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = ok(delete.execute(id))

    @PostMapping("paginate")
    fun paginate(@RequestBody customerPageRequest: CustomerPageRequest): ResponseEntity<Page<CustomerPageResponse>> =
        ok(paginate.execute(customerPageRequest.toEntity()).map { CustomerPageResponse(it) })

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String) =
        findById.execute(id)?.let { ok().body( CustomerResponse(it)) } ?: ResponseEntity.noContent()

    @PostMapping("/all")
    fun createList(@Valid @RequestBody request: List<CustomerCreateRequest>):ResponseEntity<List<CreateCustomerResponse>>  =
        created(URI("POST/customer"))
            .body(createLot.execute(request.map { it.toCustomer() }).map { CreateCustomerResponse(it) })

}

