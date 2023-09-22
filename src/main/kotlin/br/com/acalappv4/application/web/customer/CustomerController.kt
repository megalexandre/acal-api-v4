package br.com.acalappv4.application.web.customer

import br.com.acalappv4.application.web.customer.request.CustomerCreateRequest
import br.com.acalappv4.application.web.customer.request.CustomerPageRequest
import br.com.acalappv4.application.web.customer.request.CustomerPageRequestAdapter
import br.com.acalappv4.application.web.customer.request.UpdateCreateRequestAdapter
import br.com.acalappv4.application.web.customer.request.UpdateCustomerRequest
import br.com.acalappv4.application.web.customer.request.toCustomer
import br.com.acalappv4.application.web.customer.response.CustomerResponseAdapter.Companion.toResponse
import br.com.acalappv4.domain.usecase.customer.CreateCustomerUsecase
import br.com.acalappv4.domain.usecase.customer.DeleteCustomerUsecase
import br.com.acalappv4.domain.usecase.customer.FindCustomerByIdUsecase
import br.com.acalappv4.domain.usecase.customer.PaginateCustomerUsecase
import br.com.acalappv4.domain.usecase.customer.UpdateCustomerUsecase
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
@RequestMapping("customer", consumes = [APPLICATION_JSON_VALUE], produces=[APPLICATION_JSON_VALUE])
class CustomerController(
    private val delete: DeleteCustomerUsecase,
    private val create: CreateCustomerUsecase,
    private val update: UpdateCustomerUsecase,
    private val findById: FindCustomerByIdUsecase,
    private val paginate: PaginateCustomerUsecase,
    ){

    @PostMapping
    fun create(@Valid @RequestBody request: CustomerCreateRequest) =
        created(URI("POST/customer")).body(toResponse((create.execute(request.toCustomer()))))

    @PutMapping
    fun update(@Valid @RequestBody request: UpdateCustomerRequest) =
        ok(toResponse(update.execute(UpdateCreateRequestAdapter.toEntity(request))))

    @PostMapping("/all")
    fun createList(@Valid @RequestBody request: List<CustomerCreateRequest>) =
        request.forEach {
            created(URI("POST/customer")).body(toResponse(create.execute(it.toCustomer())))
        }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) =
        ok(delete.execute(id))

    @PostMapping("paginate")
    fun paginate(@RequestBody customerPageRequest: CustomerPageRequest) =
        ok(paginate.execute(CustomerPageRequestAdapter.toEntity(customerPageRequest)))

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String) =
        findById.execute(id)?.let { ok().body(toResponse(it)) } ?: ResponseEntity.noContent()

}

