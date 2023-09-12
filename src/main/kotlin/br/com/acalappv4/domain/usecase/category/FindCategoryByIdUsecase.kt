package br.com.acalappv4.domain.usecase.category

import br.com.acalappv4.domain.entity.Category
import br.com.acalappv4.domain.datasource.CategoryDataSource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class FindCategoryByIdUsecase(
    private val categoryDataSource: CategoryDataSource
): Usecase<String, Category?> {

    override fun execute(input: String): Category? = categoryDataSource.findById(input)

}