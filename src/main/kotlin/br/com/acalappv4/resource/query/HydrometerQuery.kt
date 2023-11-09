package br.com.acalappv4.resource.query

import br.com.acalappv4.domain.dto.list.HydrometerFilter
import br.com.acalappv4.resource.query.pagesort.PaginateAndSortQuery
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class HydrometerQuery: PaginateAndSortQuery<HydrometerFilter>() {

    private val id = "id"
    private val defaultSort = Sort.by(Sort.Direction.ASC,id)
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

                if(area?.id != null){
                    addCriteria(Criteria.where("address.area.id").`is`(area.id))
                }
            }
        }
    }

}


