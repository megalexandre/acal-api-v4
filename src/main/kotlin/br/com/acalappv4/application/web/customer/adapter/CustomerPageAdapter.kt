package br.com.acalappv4.application.web.customer.adapter

import br.com.acalappv4.application.web.customer.request.CustomerPageRequest
import br.com.acalappv4.domain.dto.PageFilterCustomer

class CustomerPageAdapter {

    companion object{

        fun toEntity(request: CustomerPageRequest): PageFilterCustomer = with(request) {
            PageFilterCustomer(
                id = id,
                name =  name,
                documentNumber = documentNumber,
                personType = personType,
                active = active,
                page = page,
                sort = sort
            )
        }

    }

}