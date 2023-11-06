package br.com.acalappv4.domain.usecase.hydrometer

import br.com.acalappv4.domain.entity.Hydrometer
import br.com.acalappv4.domain.usecase.Usecase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateHydrometerLotUsecase(
    private val createHydrometerUsecase: CreateHydrometerUsecase,
): Usecase<List<Hydrometer>, List<Hydrometer>> {

    @Transactional
    override fun execute(input: List<Hydrometer>): List<Hydrometer> {
        input.forEach { createHydrometerUsecase.execute(it) }
        return input
    }

}