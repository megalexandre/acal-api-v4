package br.com.acalappv4.domain.usecase.address

import br.com.acalappv4.domain.datasource.AddressDataSource
import br.com.acalappv4.domain.dto.list.AddressFilter
import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class FindAllAddressUsecase  (
    private val dataSource: AddressDataSource,
): Usecase<AddressFilter?, List<Address>> {

    override fun execute(input: AddressFilter?): List<Address> =
        dataSource.findAll(input?: AddressFilter())

}