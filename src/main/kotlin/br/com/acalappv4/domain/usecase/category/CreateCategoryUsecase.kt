package br.com.acalappv4.domain.usecase.category

import br.com.acalappv4.domain.entity.Category
import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.resources.CategoryDataSource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class CreateCategoryUsecase(
    private val categoryDataSource: CategoryDataSource,
): Usecase<Category, Category> {

    override fun execute(input: Category): Category {

        categoryDataSource.findByNameAndType(input.name, input.type)?.let {
            throw InvalidUsecaseException("duplicated category name and type")
        }

        return categoryDataSource.save(category = input)
    }

}