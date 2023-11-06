package br.com.acalappv4.domain.usecase.hydrometer

import br.com.acalappv4.domain.datasource.HydrometerDataSource
import br.com.acalappv4.domain.dto.page.HydrometerPageFilter
import br.com.acalappv4.domain.entity.Hydrometer
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class PaginateHydrometerUsecase(
    private val dataSource: HydrometerDataSource
): Usecase<HydrometerPageFilter, Page<Hydrometer>> {

    override fun execute(input: HydrometerPageFilter): Page<Hydrometer> = dataSource.paginate(input)

}