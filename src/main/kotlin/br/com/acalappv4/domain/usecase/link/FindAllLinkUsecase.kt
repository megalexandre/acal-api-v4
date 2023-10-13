package br.com.acalappv4.domain.usecase.link

import br.com.acalappv4.domain.datasource.LinkDataSource
import br.com.acalappv4.domain.dto.list.LinkFilter
import br.com.acalappv4.domain.entity.Link
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class FindAllLinkUsecase(
    private val dataSource: LinkDataSource,
): Usecase<LinkFilter, List<Link>> {

    override fun execute(input: LinkFilter): List<Link> = dataSource.findAll(input)

}