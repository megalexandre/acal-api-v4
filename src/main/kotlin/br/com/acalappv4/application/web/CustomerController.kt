package br.com.acalappv4.application.web

import br.com.acalappv4.application.web.customer.CustomerSaveRequest
import br.com.acalappv4.application.web.customer.CustomerSaveResponse
import br.com.acalappv4.application.web.customer.toCustomer
import br.com.acalappv4.application.web.customer.toCustomerSaveResponse
import br.com.acalappv4.domain.usecase.customer.CreateCustomerUsecase
import br.com.acalappv4.domain.usecase.customer.DeleteCustomerUsecase
import jakarta.validation.Valid
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.noContent
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customer", consumes = [APPLICATION_JSON_VALUE], produces=[APPLICATION_JSON_VALUE])
class CustomerController(
    private val usecase: CreateCustomerUsecase,
    private val deleteCustomerUsecase: DeleteCustomerUsecase
    ){

    @PostMapping
    fun save(@Valid @RequestBody request: CustomerSaveRequest): ResponseEntity<CustomerSaveResponse> =
        ResponseEntity(usecase.execute(request.toCustomer()).toCustomerSaveResponse(), CREATED)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String){
        deleteCustomerUsecase.execute(id)
        noContent()
    }


}