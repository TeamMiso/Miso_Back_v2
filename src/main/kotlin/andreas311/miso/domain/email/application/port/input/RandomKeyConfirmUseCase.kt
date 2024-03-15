package andreas311.miso.domain.email.application.port.input

import andreas311.miso.domain.email.application.port.input.dto.RandomKeyDto

interface RandomKeyConfirmUseCase {
    fun execute(randomKeyDto: RandomKeyDto)
}