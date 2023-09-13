package br.com.acalappv4.domain.usecase.address

import br.com.acalappv4.domain.datasource.AddressDataSource
import br.com.acalappv4.domain.dto.PageFilterAddress
import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class PaginateAddressUsecase  (
    private val dataSource: AddressDataSource,
): Usecase<PageFilterAddress, Page<Address>> {

    override fun execute(input: PageFilterAddress) = dataSource.paginate(input)

}