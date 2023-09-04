package br.com.acalappv4.domain.usecase.customer

import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.resources.CustomerResource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class CreateCustomerUsecase(
    private val customerResource: CustomerResource
): Usecase<Customer, Customer> {

    override fun execute(input: Customer): Customer {

        if(customerResource.existsByDocument(input.documentNumber)){
            throw InvalidUsecaseException("")
        }

        return customerResource.save(customer = input)
    }


}