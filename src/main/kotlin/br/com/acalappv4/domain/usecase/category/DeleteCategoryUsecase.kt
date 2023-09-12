package br.com.acalappv4.domain.usecase.category

import br.com.acalappv4.domain.datasource.CategoryDataSource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class DeleteCategoryUsecase(
    private val categoryDataSource: CategoryDataSource,
): Usecase<String, Unit> {

    override fun execute(input: String): Unit = categoryDataSource.delete(id = input)

}