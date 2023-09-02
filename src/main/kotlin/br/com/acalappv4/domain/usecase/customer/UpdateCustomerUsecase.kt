package br.com.acalappv4.domain.usecase.customer

import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.resources.customer.CustomerResource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class UpdateCustomerUsecase(
    private val customerResource: CustomerResource
): Usecase<Customer, Customer> {

    override fun execute(input: Customer): Customer {

        customerResource.findByDocument(input.document)?.let {
            if(it.id != input.id){
                throw InvalidUsecaseException("Other use has ${input.document} registered")
            }
        } ?: {
            throw InvalidUsecaseException("use with document: ${input.document} does not exists")
        }

        return customerResource.save(input)
    }


}