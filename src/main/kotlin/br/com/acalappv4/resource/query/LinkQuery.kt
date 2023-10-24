package br.com.acalappv4.resource.query

import br.com.acalappv4.domain.dto.list.LinkFilter
import br.com.acalappv4.resource.query.pagesort.PaginateAndSortQuery
import br.com.acalappv4.util.normalize
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

                if(customer?.name != null){
                    addCriteria(Criteria.where("customer.nameNormalized").regex(customer.name.normalize()))
                }

                if(category?.id != null){
                    addCriteria(Criteria.where("category.id").regex(category.id))
                }

                if(area?.id != null){
                    addCriteria(Criteria.where("address.area.id").regex(area.id))
                }

            }
        }
    }
}


