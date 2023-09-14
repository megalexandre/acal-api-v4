package br.com.acalappv4.domain.usecase.area

import br.com.acalappv4.domain.datasource.AreaDataSource
import br.com.acalappv4.domain.entity.Area
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class UpdateAreaUsecase (
    private val dataSource: AreaDataSource,
): Usecase<Area, Area> {

    override fun execute(input: Area) = dataSource.update(input)

}