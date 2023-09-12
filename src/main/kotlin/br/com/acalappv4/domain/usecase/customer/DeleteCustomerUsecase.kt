package br.com.acalappv4.domain.usecase.customer

import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.datasource.CustomerDataSource
import br.com.acalappv4.domain.datasource.LinkDataSource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class DeleteCustomerUsecase(
    private val customerDataSource: CustomerDataSource,
    private val linkDataSource: LinkDataSource,
): Usecase<String, Unit> {

    override fun execute(input: String) {

        linkDataSource.existsByCustomer(customerId = input).let {
            if(it){
                throw InvalidUsecaseException("this person has a link associated")
            }
        }

        return customerDataSource.delete(input)
    }


}