package br.com.acalappv4.domain.usecase.address

import br.com.acalappv4.domain.datasource.AddressDataSource
import br.com.acalappv4.domain.dto.list.AddressFilter
import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class CreateAddressUsecase  (
    private val dataSource: AddressDataSource,
): Usecase<Address, Address> {

    override fun execute(input: Address): Address {
        validDuplicity(input)
        return dataSource.save(address = input)
    }

    private fun validDuplicity(input: Address){
        if(dataSource.findAll(AddressFilter(
            number = input.number,
            letter = input.letter,
            area = input.area,
        )).isNotEmpty()){
            throw InvalidUsecaseException("duplicated address")
        }
    }

}