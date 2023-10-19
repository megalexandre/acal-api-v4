package br.com.acalappv4.domain.usecase.link

import br.com.acalappv4.domain.datasource.LinkDataSource
import br.com.acalappv4.domain.dto.page.LinkPageFilter
import br.com.acalappv4.domain.entity.Link
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class PaginateLinkUsecase(
    private val dataSource: LinkDataSource,
): Usecase<LinkPageFilter, Page<Link>> {

    override fun execute(input: LinkPageFilter) = dataSource.paginate(input)

}