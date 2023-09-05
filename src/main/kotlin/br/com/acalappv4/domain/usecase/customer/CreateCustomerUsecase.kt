package br.com.acalappv4.domain.usecase.customer

import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.resources.CustomerResource
import br.com.acalappv4.domain.usecase.Usecase
import br.com.acalappv4.domain.usecase.phonenumber.ValidPhoneNumberListUsecase
import org.springframework.stereotype.Service

@Service
class CreateCustomerUsecase(
    private val customerResource: CustomerResource,
    private val validPhoneNumberListUsecase: ValidPhoneNumberListUsecase,
): Usecase<Customer, Customer> {

    override fun execute(input: Customer): Customer {

        if(customerResource.existsByDocument(input.documentNumber)){
         throw InvalidUsecaseException("o documento já está cadastrados")
        }

        validPhoneNumberListUsecase.execute(input.phoneNumbers)

        return customerResource.save(customer = input)
    }


}