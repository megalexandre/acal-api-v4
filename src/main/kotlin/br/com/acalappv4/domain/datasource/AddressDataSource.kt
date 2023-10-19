package br.com.acalappv4.domain.datasource

import br.com.acalappv4.domain.dto.list.AddressFilter
import br.com.acalappv4.domain.dto.page.AddressPageFilter
import br.com.acalappv4.domain.entity.Address
import org.springframework.data.domain.Page

interface AddressDataSource {

    fun save(address: Address): Address

    fun update(address: Address): Address

    fun delete(id: String)

    fun paginate(addressPageFilter: AddressPageFilter): Page<Address>

    fun findAll(): List<Address>

    fun findAll(filter: AddressFilter): List<Address>

    fun findById(id: String): Address?

}