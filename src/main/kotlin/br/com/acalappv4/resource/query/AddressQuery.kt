package br.com.acalappv4.resource.query


import br.com.acalappv4.domain.dto.PageFilterAddress
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction.ASC
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class AddressQuery(private val addressFilter: PageFilterAddress) {

    private val defaultSort = Sort.by( ASC,"id")

    fun pageRequest(): PageRequest =
        PageRequest.of(
            addressFilter.page?.number ?: 0,
            addressFilter.page?.size ?: 10,

            when(val sort = addressFilter.sort){
                null -> defaultSort
                else -> Sort.by( sort.direction?: ASC, sort.field ?: "id")
            }
        )

    fun query(): Query = Query().apply {
        with(addressFilter){

            if (!id.isNullOrEmpty()) {
                addCriteria(Criteria.where("id").`is`(id))
            }

            if(!number.isNullOrEmpty()){
                addCriteria(Criteria.where("number").`is`(number))
            }

            if(!letter.isNullOrEmpty()){
                addCriteria(Criteria.where("letter").`is`(letter))
            }

            if(area != null){
                addCriteria(Criteria.where("area.id").`is`(area.id))
            }
        }
    }

}

