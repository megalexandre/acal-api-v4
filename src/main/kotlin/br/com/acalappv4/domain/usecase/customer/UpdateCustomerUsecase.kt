package br.com.acalappv4.domain.usecase.customer

import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.resources.CustomerResource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class UpdateCustomerUsecase(
    private val customerResource: CustomerResource
): Usecase<Customer, Customer> {

    override fun execute(input: Customer): Customer {

        if(!input.isValidPhoneNumbers){
            throw InvalidUsecaseException("a lista de números de telefones não é valida")
        }

        customerResource.findByDocument(input.documentNumber)
            .let {
                when(it){
                    null -> throw InvalidUsecaseException("use with document: ${input.documentNumber} does not exists")
                    else -> {
                        if(it.id != input.id){
                            throw InvalidUsecaseException("Other customer has ${input.documentNumber} registered")
                        }
                    }
                }

            }



        return customerResource.save(input)
    }


}