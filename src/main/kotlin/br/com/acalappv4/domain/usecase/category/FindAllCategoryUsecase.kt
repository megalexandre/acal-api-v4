package br.com.acalappv4.domain.usecase.category

import br.com.acalappv4.domain.entity.Category
import br.com.acalappv4.domain.resources.CategoryDataSource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class FindAllCategoryUsecase(
    private val categoryDataSource: CategoryDataSource,
): Usecase<Unit, List<Category>> {

    override fun execute(input: Unit): List<Category> = categoryDataSource.findAll()

}