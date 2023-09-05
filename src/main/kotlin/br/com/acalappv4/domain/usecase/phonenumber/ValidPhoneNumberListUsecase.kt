package br.com.acalappv4.domain.usecase.phonenumber

import br.com.acalappv4.domain.entity.PhoneNumber
import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class ValidPhoneNumberListUsecase: Usecase<List<PhoneNumber>?, Unit> {

    override fun execute(input: List<PhoneNumber>?)  {
        if(input.isNullOrEmpty()){
            return
        }

        if (input.none { it.preferential }) {
            throw InvalidUsecaseException("a customer must be a preferential number")
        }

        if (input.count { it.preferential } > 1) {
            throw InvalidUsecaseException("a customer must be only a preferential number")
        }

        if(input.distinctBy { it.number }.size != input.size){
            throw InvalidUsecaseException("has duplicated phone number")
        }

    }

}