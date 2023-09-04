package br.com.acalappv4.application.web

import br.com.acalappv4.application.web.customer.CustomerSaveRequest
import br.com.acalappv4.application.web.customer.CustomerSaveResponse
import br.com.acalappv4.application.web.customer.toCustomer
import br.com.acalappv4.application.web.customer.toCustomerSaveResponse
import br.com.acalappv4.domain.usecase.customer.CreateCustomerUsecase
import jakarta.validation.Valid
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customer", produces=[APPLICATION_JSON_VALUE])
class CustomerController(
    private val createCustomerUsecase: CreateCustomerUsecase
    ){

    @PostMapping
    fun save(@Valid @RequestBody request: CustomerSaveRequest): ResponseEntity<CustomerSaveResponse> =
         ResponseEntity(createCustomerUsecase.execute(request.toCustomer()).toCustomerSaveResponse(), CREATED)

}