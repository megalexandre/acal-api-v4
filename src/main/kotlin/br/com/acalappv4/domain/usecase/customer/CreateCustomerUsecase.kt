package br.com.acalappv4.domain.usecase.customer

import br.com.acalappv4.domain.datasource.CustomerDataSource
import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class CreateCustomerUsecase(
    private val customerDataSource: CustomerDataSource,
): Usecase<Customer, Customer> {

    override fun execute(input: Customer): Customer {

        if(!input.isValidPhoneNumbers){
            throw InvalidUsecaseException("a lista de números de telefones não é valida")
        }

        if(customerDataSource.existsByDocument(input.documentNumber)){
            throw InvalidUsecaseException("o documento já está cadastrado: ${input.documentNumber.number}")
        }

        return customerDataSource.save(customer = input)
    }

}