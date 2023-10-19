package br.com.acalappv4.resource.query


import br.com.acalappv4.domain.dto.list.AreaFilter
import br.com.acalappv4.resource.query.pagesort.PaginateAndSortQuery
import br.com.acalappv4.util.normalize
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class AreaQuery: PaginateAndSortQuery<AreaFilter>()  {

    override fun query(filter: AreaFilter?): Query = Query().apply {
        if(filter != null){
            with(filter){

                if (!id.isNullOrEmpty()) {
                    addCriteria(Criteria.where("id").`is`(id))
                }

                if (!name.isNullOrEmpty()) {
                    addCriteria(Criteria.where("nameNormalized").regex("^${name.normalize()}"))
                }
            }
        }
    }

}

