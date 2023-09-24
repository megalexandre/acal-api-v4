package br.com.acalappv4.domain.usecase.customer

import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateCustomerLotUsecase(
    private val createCustomerUsecase: CreateCustomerUsecase,
): Usecase<List<Customer>, List<Customer>> {

    @Transactional
    override fun execute(input: List<Customer>): List<Customer> {
        input.forEach { createCustomerUsecase.execute(it) }
        return input
    }

}