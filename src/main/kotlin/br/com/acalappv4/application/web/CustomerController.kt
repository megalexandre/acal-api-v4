package br.com.acalappv4.application.web

import br.com.acalappv4.application.web.customer.adapter.toCustomer
import br.com.acalappv4.application.web.customer.adapter.toCustomerPage
import br.com.acalappv4.application.web.customer.adapter.toCustomerResponse
import br.com.acalappv4.application.web.customer.adapter.toCustomerSaveResponse
import br.com.acalappv4.application.web.customer.request.CustomerSaveRequest
import br.com.acalappv4.domain.dto.CustomerPageFilter
import br.com.acalappv4.domain.usecase.customer.CreateCustomerUsecase
import br.com.acalappv4.domain.usecase.customer.DeleteCustomerUsecase
import br.com.acalappv4.domain.usecase.customer.FindCustomerByIdUsecase
import br.com.acalappv4.domain.usecase.customer.PaginateCustomerUsecase
import jakarta.validation.Valid
import java.net.URI
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity.created
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customer", consumes = [APPLICATION_JSON_VALUE], produces=[APPLICATION_JSON_VALUE])
class CustomerController(
    private val usecase: CreateCustomerUsecase,
    private val deleteCustomerUsecase: DeleteCustomerUsecase,
    private val paginateCustomerUsecase: PaginateCustomerUsecase,
    private val findCustomerByIdUsecase: FindCustomerByIdUsecase,
    ){

    @PostMapping
    fun save(@Valid @RequestBody request: CustomerSaveRequest) =
        created(URI("POST/customer")).body(usecase.execute(request.toCustomer()).toCustomerSaveResponse())

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String) =
        findCustomerByIdUsecase.execute(id)?.let {
            ok().body(it.toCustomerResponse())
        } ?: noContent()

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String){
        deleteCustomerUsecase.execute(id)
        noContent()
    }

    @GetMapping
    fun paginate() = paginateCustomerUsecase.execute(CustomerPageFilter()).toCustomerPage()

}