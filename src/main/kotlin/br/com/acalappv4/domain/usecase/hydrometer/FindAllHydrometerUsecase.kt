package br.com.acalappv4.domain.usecase.hydrometer

import br.com.acalappv4.domain.datasource.HydrometerDataSource
import br.com.acalappv4.domain.datasource.LinkDataSource
import br.com.acalappv4.domain.dto.list.HydrometerFilter
import br.com.acalappv4.domain.dto.list.LinkFilter
import br.com.acalappv4.domain.entity.Hydrometer
import br.com.acalappv4.domain.entity.Link
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class FindAllHydrometerUsecase(
    private val dataSource: HydrometerDataSource,
): Usecase<HydrometerFilter, List<Hydrometer>?> {

    override fun execute(input: HydrometerFilter): List<Hydrometer> = dataSource.findAll(input)

}