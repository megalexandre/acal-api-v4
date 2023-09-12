package br.com.acalappv4.domain.usecase.customer

import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.datasource.CustomerDataSource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class FindCustomerByIdUsecase(
    private val customerDataSource: CustomerDataSource
): Usecase<String, Customer?> {

    override fun execute(input: String): Customer? = customerDataSource.findById(input)


}