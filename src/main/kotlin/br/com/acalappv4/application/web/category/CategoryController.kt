package br.com.acalappv4.application.web.category

import br.com.acalappv4.application.web.category.request.CategoryPageFilterRequest
import br.com.acalappv4.application.web.category.request.CreateCategoryRequest
import br.com.acalappv4.application.web.category.request.UpdateCategoryRequest
import br.com.acalappv4.application.web.category.response.CategoryResponse
import br.com.acalappv4.application.web.category.response.CreateCategoryResponse
import br.com.acalappv4.application.web.category.response.toCategoryPageResponse
import br.com.acalappv4.domain.usecase.category.CreateCategoryLotUsecase
import br.com.acalappv4.domain.usecase.category.CreateCategoryUsecase
import br.com.acalappv4.domain.usecase.category.DeleteCategoryUsecase
import br.com.acalappv4.domain.usecase.category.FindAllCategoryUsecase
import br.com.acalappv4.domain.usecase.category.FindCategoryByIdUsecase
import br.com.acalappv4.domain.usecase.category.PaginateCategoryUsecase
import br.com.acalappv4.domain.usecase.category.UpdateCategoryUsecase
import jakarta.validation.Valid
import java.net.URI
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("category", consumes = [APPLICATION_JSON_VALUE], produces=[APPLICATION_JSON_VALUE])
class CategoryController(
    private val create: CreateCategoryUsecase,
    private val createLot: CreateCategoryLotUsecase,
    private val findById: FindCategoryByIdUsecase,
    private val findAll: FindAllCategoryUsecase,
    private val delete: DeleteCategoryUsecase,
    private val paginate: PaginateCategoryUsecase,
    private val update: UpdateCategoryUsecase
){

    @PostMapping("/all")
    fun createAll(@Valid @RequestBody request: List<CreateCategoryRequest>) =
        created(URI("POST/category"))
            .body( createLot.execute(request.map { it.toEntity() }).map { CreateCategoryResponse(it) })

    @PostMapping
    fun create(@Valid @RequestBody request: CreateCategoryRequest): ResponseEntity<CreateCategoryResponse> =
        created(URI("POST/category")).body(CreateCategoryResponse(create.execute(request.toEntity())))

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String) =
        findById.execute(id)?.let { ok().body(CategoryResponse(it)) } ?: noContent()

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = ok(delete.execute(id))

    @PostMapping("/paginate")
    fun paginate(@RequestBody request: CategoryPageFilterRequest) =
        ok(paginate.execute(request.toEntity()).toCategoryPageResponse())

    @PutMapping
    fun update(@Valid @RequestBody request: UpdateCategoryRequest) = ok(update.execute(request.toEntity()))

}

