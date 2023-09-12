package br.com.acalappv4.domain.usecase.category

import br.com.acalappv4.domain.entity.Category
import br.com.acalappv4.domain.datasource.CategoryDataSource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class UpdateCategoryUsecase(
    private val categoryDataSource: CategoryDataSource,
): Usecase<Category, Category> {

    override fun execute(input: Category): Category = categoryDataSource.save(category = input)

}