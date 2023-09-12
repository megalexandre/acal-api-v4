package br.com.acalappv4.domain.usecase.area

import br.com.acalappv4.domain.datasource.AreaDataSource
import br.com.acalappv4.domain.entity.Area
import br.com.acalappv4.domain.usecase.Usecase

class UpdateAreaUsecase (
    private val dataSource: AreaDataSource,
): Usecase<Area, Area> {

    override fun execute(input: Area) = dataSource.save(input)

}