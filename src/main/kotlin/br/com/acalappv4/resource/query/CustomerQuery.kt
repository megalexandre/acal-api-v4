package br.com.acalappv4.resource.query

import br.com.acalappv4.domain.dto.list.CustomerFilter
import br.com.acalappv4.resource.query.pagesort.PaginateAndSortQuery
import br.com.acalappv4.util.normalize
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class CustomerQuery: PaginateAndSortQuery<CustomerFilter>() {

    override fun query(filter: CustomerFilter?): Query = Query().apply {
        if (filter != null) {
            with(filter) {
                if (!id.isNullOrEmpty()) {
                    addCriteria(Criteria.where("id").`is`(id))
                }

                if (!name.isNullOrEmpty()) {
                    addCriteria(Criteria.where("nameNormalized").regex(name.normalize()))
                }

                if (!documentNumber.isNullOrEmpty()) {
                    addCriteria(Criteria.where("documentNumber.number").regex("^${documentNumber.normalize()}"))
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


}

