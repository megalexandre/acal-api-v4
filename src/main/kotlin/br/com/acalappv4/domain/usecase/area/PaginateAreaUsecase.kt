package br.com.acalappv4.domain.usecase.area

import br.com.acalappv4.domain.datasource.AreaDataSource
import br.com.acalappv4.domain.dto.page.AreaPageFilter
import br.com.acalappv4.domain.entity.Area
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class PaginateAreaUsecase(
    private val dataSource: AreaDataSource,
): Usecase<AreaPageFilter, Page<Area>> {

    override fun execute(input: AreaPageFilter) = dataSource.paginate(input)

}