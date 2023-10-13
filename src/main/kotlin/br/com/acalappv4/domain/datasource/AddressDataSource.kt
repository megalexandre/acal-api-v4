package br.com.acalappv4.domain.datasource

import br.com.acalappv4.domain.dto.page.PageFilterAddress
import br.com.acalappv4.domain.entity.Address
import org.springframework.data.domain.Page

interface AddressDataSource {

    fun save(address: Address): Address

    fun update(address: Address): Address

    fun delete(id: String)

    fun paginate(pageFilterAddress: PageFilterAddress): Page<Address>

    fun findAll(): List<Address>

    fun findAll(pageFilterAddress: PageFilterAddress): List<Address>

    fun findById(id: String): Address?

}