package br.com.acalappv4.domain.datasource

import br.com.acalappv4.domain.dto.list.HydrometerFilter
import br.com.acalappv4.domain.dto.page.AreaPageFilter
import br.com.acalappv4.domain.dto.page.HydrometerPageFilter
import br.com.acalappv4.domain.entity.Area
import br.com.acalappv4.domain.entity.Hydrometer
import org.springframework.data.domain.Page

interface HydrometerDataSource {

    fun save(hydrometer: Hydrometer): Hydrometer

    fun update(hydrometer: Hydrometer): Hydrometer

    fun delete(id: String)

    fun paginate(pageFilter: HydrometerPageFilter): Page<Hydrometer>

    fun findAll(filter: HydrometerFilter): List<Hydrometer>

    fun findAll(): List<Hydrometer>

    fun findById(id: String): Hydrometer?

}