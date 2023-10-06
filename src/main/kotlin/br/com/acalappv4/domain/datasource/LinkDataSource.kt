package br.com.acalappv4.domain.datasource

import br.com.acalappv4.domain.dto.PageFilterLink
import br.com.acalappv4.domain.entity.Address
import br.com.acalappv4.domain.entity.Link
import org.springframework.data.domain.Page

interface LinkDataSource {

    fun existsByCustomer(customerId: String): Boolean

    fun findByAddressAndStatus(address: Address, active: Boolean): Link?

    fun save(link: Link) : Link

    fun findAll(): List<Link>

    fun paginate(pageFilterLink: PageFilterLink): Page<Link>
}