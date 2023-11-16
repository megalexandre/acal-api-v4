package br.com.acalappv4.domain.usecase.hydrometer

import br.com.acalappv4.domain.datasource.HydrometerDataSource
import br.com.acalappv4.domain.entity.Hydrometer
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class FindHydrometerByIdUsecase(
    private val dataSource: HydrometerDataSource
): Usecase<String, Hydrometer?> {

    override fun execute(input: String): Hydrometer? = dataSource.findById(input)


}