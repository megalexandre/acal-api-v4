package br.com.acalappv4.domain.usecase.customer

import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.resources.CustomerResource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class FindCustomerByIdUsecase(
    private val customerResource: CustomerResource
): Usecase<String, Customer?> {

    override fun execute(input: String): Customer? = customerResource.findById(input)


}