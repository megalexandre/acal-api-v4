package br.com.acalappv4.domain.usecase.customer

import br.com.acalappv4.domain.dto.page.CustomerPageFilter
import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.datasource.CustomerDataSource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class PaginateCustomerUsecase(
    private val customerDataSource: CustomerDataSource
): Usecase<CustomerPageFilter, Page<Customer>> {

    override fun execute(input: CustomerPageFilter): Page<Customer> = customerDataSource.paginate(input)

}