package br.com.acalappv4.domain.usecase.hydrometer

import br.com.acalappv4.domain.datasource.HydrometerDataSource
import br.com.acalappv4.domain.dto.list.HydrometerFilter
import br.com.acalappv4.domain.entity.Hydrometer
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class FindHydrometerUsecase(
    private val dataSource: HydrometerDataSource
): Usecase<HydrometerFilter, Hydrometer?> {
    override fun execute(input: HydrometerFilter): Hydrometer? = dataSource.findAll(input).firstOrNull()
}