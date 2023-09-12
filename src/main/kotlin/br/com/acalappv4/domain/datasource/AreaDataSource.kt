package br.com.acalappv4.domain.datasource

import br.com.acalappv4.domain.dto.PageFilterArea
import br.com.acalappv4.domain.entity.Area
import org.springframework.data.domain.Page

interface AreaDataSource {

    fun save(area: Area): Area

    fun delete(id: String)

    fun paginate(pageFilterArea: PageFilterArea): Page<Area>

    fun findAll(): List<Area>

    fun findByName(name: String): Area?

    fun findById(id: String): Area?

}