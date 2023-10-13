package br.com.acalappv4.resource.query

import br.com.acalappv4.domain.dto.list.InvoiceFilter
import br.com.acalappv4.resource.query.def.DefQuery
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class InvoiceQuery: DefQuery() {

    fun query(invoiceFilter: InvoiceFilter?): Query = Query().apply {
        if(invoiceFilter != null){
            with(invoiceFilter){
                if (!id.isNullOrEmpty()) {
                    addCriteria(Criteria.where("id").`is`(id))
                }

                if (link?.id != null) {
                    addCriteria(Criteria.where("link.id").`is`(link.id))
                }

                if (reference != null) {
                    addCriteria(Criteria.where("reference.year").`is`(reference.year.value))
                    addCriteria(Criteria.where("reference.month").`is`(reference.month.value))
                }

            }
        }
    }
}


