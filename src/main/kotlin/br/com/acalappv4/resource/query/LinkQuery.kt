package br.com.acalappv4.resource.query

import br.com.acalappv4.domain.dto.list.LinkFilter
import br.com.acalappv4.resource.query.pagesort.PaginateAndSortQuery
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class LinkQuery: PaginateAndSortQuery<LinkFilter>() {

    override fun query(filter: LinkFilter?): Query = Query().apply {
        if(filter != null){
            with(filter){
                if (!id.isNullOrEmpty()) {
                    addCriteria(Criteria.where("id").`is`(id))
                }

                if (active != null) {
                    addCriteria(Criteria.where("active").`is`(active))
                }
            }
        }
    }


}


