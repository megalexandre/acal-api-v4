package br.com.acalappv4.domain.usecase.area

import br.com.acalappv4.domain.datasource.AreaDataSource
import br.com.acalappv4.domain.entity.Area
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class FindAllAreaUsecase(
    private val dataSource: AreaDataSource,
): Usecase<Unit, List<Area>> {

    override fun execute(input: Unit) = dataSource.findAll()

}