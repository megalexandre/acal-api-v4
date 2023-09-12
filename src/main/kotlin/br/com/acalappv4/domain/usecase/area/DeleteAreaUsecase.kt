package br.com.acalappv4.domain.usecase.area

import br.com.acalappv4.domain.datasource.AreaDataSource
import br.com.acalappv4.domain.usecase.Usecase

class DeleteAreaUsecase (
    private val dataSource: AreaDataSource,
): Usecase<String, Unit> {

    override fun execute(input: String) = dataSource.delete(id = input)

}