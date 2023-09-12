package br.com.acalappv4.domain.datasource

import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.entity.Link

interface LinkDataSource {

    fun existsByCustomer(customerId: String): Boolean

    fun findByAddressAndStatus(address: Address, active: Boolean): Link?

    fun save(link: Link) : Link

}