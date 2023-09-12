package br.com.acalappv4.domain.usecase.area

import br.com.acalappv4.domain.datasource.AreaDataSource
import br.com.acalappv4.domain.entity.Area
import br.com.acalappv4.domain.usecase.Usecase

class FindAreaByIdUsecase(
    private val dataSource: AreaDataSource,
): Usecase<String, Area?> {

    override fun execute(input: String) = dataSource.findById(input)

}