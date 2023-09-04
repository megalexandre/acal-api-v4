package br.com.acalappv4.resource.resourceImpl

import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.Link
import br.com.acalappv4.domain.resources.LinkResource
import org.springframework.stereotype.Service

@Service
class LinkResourceImpl: LinkResource {

    override fun existsByCustomer(customer: Customer): Boolean = true


    override fun findByAddressAndStatus(address: Address, active: Boolean): Link? {
        TODO("Not yet implemented")
    }

    override fun save(link: Link): Link {
        TODO("Not yet implemented")
    }

}