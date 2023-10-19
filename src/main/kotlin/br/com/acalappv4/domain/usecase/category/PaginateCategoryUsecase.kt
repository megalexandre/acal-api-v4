package br.com.acalappv4.domain.usecase.category

import br.com.acalappv4.domain.dto.page.CategoryPageFilter
import br.com.acalappv4.domain.entity.Category
import br.com.acalappv4.domain.datasource.CategoryDataSource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class PaginateCategoryUsecase(
    private val categoryDataSource: CategoryDataSource
): Usecase<CategoryPageFilter, Page<Category>> {

    override fun execute(input: CategoryPageFilter): Page<Category> = categoryDataSource.paginate(input)

}