package br.com.acalappv4.resource.query

import br.com.acalappv4.domain.dto.list.InvoiceFilter
import br.com.acalappv4.resource.query.pagesort.PaginateAndSortQuery
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class InvoiceQuery: PaginateAndSortQuery<InvoiceFilter>() {

    override fun query(filter: InvoiceFilter?): Query = Query().apply {
        if(filter != null){
            with(filter){
                if (!id.isNullOrEmpty()) {
                    addCriteria(Criteria.where("id").`is`(id))
                }

                if(!linkId.isNullOrEmpty()){
                    addCriteria(Criteria.where("link.id").`is`(linkId))
                }

                if (reference != null) {
                    addCriteria(Criteria.where("reference.year").`is`(reference.year.value))
                    addCriteria(Criteria.where("reference.month").`is`(reference.month.value))
                }

            }
        }
    }

}


