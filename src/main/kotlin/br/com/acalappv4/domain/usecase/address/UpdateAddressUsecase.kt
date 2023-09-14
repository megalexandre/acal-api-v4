package br.com.acalappv4.domain.usecase.address

import br.com.acalappv4.domain.datasource.AddressDataSource
import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class UpdateAddressUsecase  (
    private val dataSource: AddressDataSource,
): Usecase<Address, Address> {

    override fun execute(input: Address): Address = dataSource.update(address = input)

}