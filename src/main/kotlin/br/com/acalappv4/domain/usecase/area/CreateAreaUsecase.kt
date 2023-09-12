package br.com.acalappv4.domain.usecase.area

import br.com.acalappv4.domain.datasource.AreaDataSource
import br.com.acalappv4.domain.entity.Area
import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class CreateAreaUsecase (
    private val dataSource: AreaDataSource,
): Usecase<Area, Area> {

    override fun execute(input: Area): Area {

        dataSource.findByName(input.name)?.let {
            throw InvalidUsecaseException("duplicated area name: ${input.name}")
        }

        return dataSource.save(area = input)
    }

}