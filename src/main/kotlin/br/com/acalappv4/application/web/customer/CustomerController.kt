package br.com.acalappv4.application.web.customer

import br.com.acalappv4.application.web.customer.request.CustomerCreateRequest
import br.com.acalappv4.application.web.customer.request.CustomerPageRequest
import br.com.acalappv4.application.web.customer.request.UpdateCustomerRequest
import br.com.acalappv4.application.web.customer.response.CustomerCreateResponse
import br.com.acalappv4.application.web.customer.response.CustomerPageResponse
import br.com.acalappv4.application.web.customer.response.CustomerResponse
import br.com.acalappv4.domain.usecase.customer.*
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.created
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*
import java.net.URI

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
    fun create(@Valid @RequestBody request: CustomerCreateRequest): ResponseEntity<CustomerCreateResponse> =
        created(URI("POST/customer")).body(CustomerCreateResponse(create.execute(request.toCustomer())))

    @PutMapping
    fun update(@Valid @RequestBody request: UpdateCustomerRequest): ResponseEntity<CustomerCreateResponse> =
        ok(CustomerCreateResponse(update.execute(request.toEntity())))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = ok(delete.execute(id))

    @PostMapping("paginate")
    fun paginate(@RequestBody customerPageRequest: CustomerPageRequest): ResponseEntity<Page<CustomerPageResponse>> =
        ok(paginate.execute(customerPageRequest.toEntity()).map { CustomerPageResponse(it) })

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String) =
        findById.execute(id)?.let { ok().body( CustomerResponse(it)) } ?: ResponseEntity.noContent()

    @PostMapping("/all")
    fun createList(@Valid @RequestBody request: List<CustomerCreateRequest>):ResponseEntity<List<CustomerCreateResponse>>  =
        created(URI("POST/customer"))
            .body(createLot.execute(request.map { it.toCustomer() }).map { CustomerCreateResponse(it) })

}

