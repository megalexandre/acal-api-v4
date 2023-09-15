package br.com.acalappv4.domain.usecase.address

import br.com.acalappv4.domain.datasource.AddressDataSource
import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class FindAddressByIdUsecase  (
    private val dataSource: AddressDataSource,
): Usecase<String, Address?> {

    override fun execute(input: String): Address? = dataSource.findById(input)

}