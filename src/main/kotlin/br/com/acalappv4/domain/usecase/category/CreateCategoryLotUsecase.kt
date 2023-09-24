package br.com.acalappv4.domain.usecase.category

import br.com.acalappv4.domain.entity.Category
import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.datasource.CategoryDataSource
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateCategoryLotUsecase(
    private val createCategory: CreateCategoryUsecase,
): Usecase<List<Category>, List<Category>> {

    @Transactional
    override fun execute(input: List<Category>): List<Category> {
        input.forEach { createCategory.execute(it) }
        return input
    }

}