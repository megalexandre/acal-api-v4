package br.com.acalappv4.domain.usecase.customer

import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.resources.CustomerResource
import br.com.acalappv4.domain.resources.LinkResource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class DeleteCustomerUsecase(
    private val customerResource: CustomerResource,
    private val linkResource: LinkResource,
): Usecase<String, Unit> {

    override fun execute(input: String) {

        linkResource.existsByCustomer(customerId = input).let {
            if(it){
                throw InvalidUsecaseException("")
            }
        }


        return customerResource.delete(input)
    }


}