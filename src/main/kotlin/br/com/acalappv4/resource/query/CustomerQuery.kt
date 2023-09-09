package br.com.acalappv4.resource.query

import br.com.acalappv4.domain.dto.CustomerPageFilter
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction.ASC
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class CustomerQuery(private val customer: CustomerPageFilter) {

    private val defaultSort = Sort.by( ASC,"id")

    fun pageRequest(customerFilter: CustomerPageFilter): PageRequest =
        PageRequest.of(
            customerFilter.page?.number ?: 0,
            customerFilter.page?.size ?: 10,

            when(val sort = customerFilter.sort){
                null -> defaultSort
                else -> Sort.by( sort.direction?: ASC, sort.field ?: "id")
            }
        )

    fun query(customerFilter: CustomerPageFilter): Query {
        val query = Query()

        with(customerFilter){
            if (!id.isNullOrEmpty()) {
                query.addCriteria(Criteria.where("id").`is`(id))
            }

            if (!name.isNullOrEmpty()) {
                query.addCriteria(Criteria.where("name").`is`(name))
            }

            if (!documentNumber.isNullOrEmpty()) {
                query.addCriteria(Criteria.where("documentNumber.number").`is`(documentNumber))
            }

            if (!documentNumber.isNullOrEmpty()) {
                query.addCriteria(Criteria.where("documentNumber.number").`is`(documentNumber))
            }

            if (personType != null) {
                query.addCriteria(Criteria.where("personType").`is`(personType))
            }

            if (active != null) {
                query.addCriteria(Criteria.where("active").`is`(active))
            }
        }

        return query
    }


}

