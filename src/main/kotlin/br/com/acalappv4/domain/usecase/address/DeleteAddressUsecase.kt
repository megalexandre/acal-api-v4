package br.com.acalappv4.domain.usecase.address

import br.com.acalappv4.domain.datasource.AddressDataSource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class DeleteAddressUsecase  (
    private val dataSource: AddressDataSource,
): Usecase<String, Unit> {

    override fun execute(input: String): Unit = dataSource.delete(input)

}