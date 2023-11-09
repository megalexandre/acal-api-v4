package br.com.acalappv4.resource.query

import br.com.acalappv4.domain.dto.list.InvoiceFilter
import br.com.acalappv4.resource.query.pagesort.PaginateAndSortQuery
import br.com.acalappv4.util.normalize
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class InvoiceQuery: PaginateAndSortQuery<InvoiceFilter>() {

    override fun query(filter: InvoiceFilter?): Query = Query().apply {
        if(filter != null){
            with(filter){
                if(!id.isNullOrEmpty()) {
                    addCriteria(Criteria.where("id").`is`(id))
                }

                if(!linkId.isNullOrEmpty()){
                    addCriteria(Criteria.where("linkDetail.linkId").`is`(linkId))
                }

                if(!customerName.isNullOrEmpty()){
                    addCriteria(Criteria.where("linkDetail.customerNormalizedName").regex(customerName.normalize()))
                }

                if(!addressName.isNullOrEmpty()){
                    addCriteria(Criteria.where("linkDetail.addressNormalizedName").regex(addressName.normalize()))
                }

                if (reference != null) {
                    addCriteria(Criteria.where("reference.year").`is`(reference.year.value))
                    addCriteria(Criteria.where("reference.month").`is`(reference.month.value))
                }

                if (dueDate != null) {
                    addCriteria(Criteria.where("dueDate").`is`(dueDate))
                }

            }
        }
    }

}


