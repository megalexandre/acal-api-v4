package br.com.acalappv4.domain.usecase.hydrometer

import br.com.acalappv4.domain.datasource.HydrometerDataSource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class DeleteHydrometerUsecase(
    private val dataSource: HydrometerDataSource
): Usecase<String, Unit> {
    override fun execute(input: String) = dataSource.delete(input)

}