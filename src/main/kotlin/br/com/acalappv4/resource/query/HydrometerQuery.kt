package br.com.acalappv4.resource.query

import br.com.acalappv4.domain.dto.list.HydrometerFilter
import br.com.acalappv4.resource.query.pagesort.PaginateAndSortQuery
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class HydrometerQuery: PaginateAndSortQuery<HydrometerFilter>() {
    override fun query(filter: HydrometerFilter?): Query = Query().apply {
        if(filter != null){
            with(filter){
                if (!id.isNullOrEmpty()) {
                    addCriteria(Criteria.where("id").`is`(id))
                }

                if (reference != null) {
                    addCriteria(Criteria.where("reference.year").`is`(reference.year.value))
                    addCriteria(Criteria.where("reference.month").`is`(reference.month.value))
                }

                if(!addressId.isNullOrEmpty()){
                    addCriteria(Criteria.where("addressId").`is`(addressId))
                }
            }
        }
    }
}


