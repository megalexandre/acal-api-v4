package br.com.acalappv4.domain.resources

import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.entity.Customer
import br.com.acalappv4.domain.entity.Link

interface LinkResource {

    fun existsByCustomer(customer: Customer): Boolean

    fun findByAddressAndStatus(address: Address, active: Boolean): Link?

    fun save(link: Link) : Link

}