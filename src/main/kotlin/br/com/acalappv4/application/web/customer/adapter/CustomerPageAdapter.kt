package br.com.acalappv4.application.web.customer.adapter

import br.com.acalappv4.application.adapter.ApplicationAdapter
import br.com.acalappv4.application.web.customer.request.CustomerPageRequest
import br.com.acalappv4.domain.dto.CustomerPageFilter

class CustomerPageAdapter {

    companion object: ApplicationAdapter<CustomerPageRequest, CustomerPageFilter>{

        override fun toEntity(request: CustomerPageRequest): CustomerPageFilter = with(request) {
            CustomerPageFilter(
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