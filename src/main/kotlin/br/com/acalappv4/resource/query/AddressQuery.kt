package br.com.acalappv4.resource.query


import br.com.acalappv4.domain.dto.list.AddressFilter
import br.com.acalappv4.resource.query.pagesort.PaginateAndSortQuery
import br.com.acalappv4.util.normalize
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class AddressQuery: PaginateAndSortQuery<AddressFilter>() {

    override fun query(filter: AddressFilter?): Query = Query().apply {
        if (filter != null) {
            with(filter) {

                if (!id.isNullOrEmpty()) {
                    addCriteria(Criteria.where("id").`is`(id))
                }

                if (!number.isNullOrEmpty()) {
                    addCriteria(Criteria.where("number").regex(number.normalize()))
                }

                if (!letter.isNullOrEmpty()) {
                    addCriteria(Criteria.where("letter").regex(letter.normalize()))
                }

                if (area != null) {
                    addCriteria(Criteria.where("area.id").`is`(area.id))
                }

                if (hasHydrometer != null) {
                    addCriteria(Criteria.where("hasHydrometer").`is`(hasHydrometer))
                }
            }
        }
    }


}

