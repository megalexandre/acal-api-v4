package br.com.acalappv4.resource.query

import br.com.acalappv4.domain.dto.list.LinkFilter
import br.com.acalappv4.resource.query.def.DefQuery
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class LinkQuery: DefQuery() {

    fun query(linkFilter: LinkFilter?): Query = Query().apply {
        if(linkFilter != null){
            with(linkFilter){
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


