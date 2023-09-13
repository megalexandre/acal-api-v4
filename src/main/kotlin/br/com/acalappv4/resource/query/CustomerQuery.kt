package br.com.acalappv4.resource.query

import br.com.acalappv4.domain.dto.PageFilterCustomer
import br.com.acalappv4.util.normalize
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction.ASC
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class CustomerQuery(private val customerFilter: PageFilterCustomer) {

    private val defaultSort = Sort.by( ASC,"id")

    fun pageRequest(): PageRequest =
        PageRequest.of(
            customerFilter.page?.number ?: 0,
            customerFilter.page?.size ?: 10,

            when(val sort = customerFilter.sort){
                null -> defaultSort
                else -> Sort.by( sort.direction?: ASC, sort.field ?: "id")
            }
        )

    fun query(): Query = Query().apply {
        with(customerFilter){
            if (!id.isNullOrEmpty()) {
                addCriteria(Criteria.where("id").`is`(id))
            }

            if (!name.isNullOrEmpty()) {
                addCriteria(Criteria.where("nameNormalized").regex("^${name.normalize()}"))
            }

            if (!documentNumber.isNullOrEmpty()) {
                addCriteria(Criteria.where("documentNumber.number").`is`(documentNumber))
            }

            if (personType != null) {
                addCriteria(Criteria.where("personType").`is`(personType))
            }

            if (active != null) {
                addCriteria(Criteria.where("active").`is`(active))
            }
        }
    }


}

