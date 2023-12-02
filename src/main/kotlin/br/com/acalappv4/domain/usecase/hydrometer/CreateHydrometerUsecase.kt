package br.com.acalappv4.domain.usecase.hydrometer

import br.com.acalappv4.domain.datasource.HydrometerDataSource
import br.com.acalappv4.domain.dto.list.HydrometerFilter
import br.com.acalappv4.domain.entity.Hydrometer
import br.com.acalappv4.domain.exception.InvalidUsecaseException
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service
import java.time.Duration
import java.time.LocalDateTime

@Service
class CreateHydrometerUsecase(
    private val dataSource: HydrometerDataSource,
    private val findHydrometerUsecase: FindHydrometerUsecase,
): Usecase<Hydrometer, Hydrometer> {
    override fun execute(input: Hydrometer): Hydrometer  {

        Duration.between( LocalDateTime.now(),  LocalDateTime.now()).seconds

        findHydrometerUsecase.execute(input = HydrometerFilter(
            reference = input.reference,
            addressId = input.address.id,
        ))?.let {
            throw InvalidUsecaseException("A hydrometer can't has two gathering at same reference")
        }

        return dataSource.save(hydrometer = input)
    }

}