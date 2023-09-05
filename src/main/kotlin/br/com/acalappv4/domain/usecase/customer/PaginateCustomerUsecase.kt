package br.com.acalappv4.domain.usecase.customer

import br.com.acalappv4.domain.dto.CustomerPageFilter
import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.resources.CustomerResource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class PaginateCustomerUsecase(
    private val customerResource: CustomerResource
): Usecase<CustomerPageFilter, Page<Customer>> {

    override fun execute(input: CustomerPageFilter): Page<Customer> =
        customerResource.paginate(input)

}