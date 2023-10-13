package br.com.acalappv4.domain.usecase.area

import br.com.acalappv4.domain.datasource.AreaDataSource
import br.com.acalappv4.domain.dto.page.PageFilterArea
import br.com.acalappv4.domain.entity.Area
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class PaginateAreaUsecase(
    private val dataSource: AreaDataSource,
): Usecase<PageFilterArea, Page<Area>> {

    override fun execute(input: PageFilterArea) = dataSource.paginate(input)

}