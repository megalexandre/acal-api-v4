package br.com.acalappv4.domain.usecase.category

import br.com.acalappv4.domain.dto.PageFilterCategory
import br.com.acalappv4.domain.entity.Category
import br.com.acalappv4.domain.datasource.CategoryDataSource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class PaginateCategoryUsecase(
    private val categoryDataSource: CategoryDataSource
): Usecase<PageFilterCategory, Page<Category>> {

    override fun execute(input: PageFilterCategory): Page<Category> = categoryDataSource.paginate(input)

}