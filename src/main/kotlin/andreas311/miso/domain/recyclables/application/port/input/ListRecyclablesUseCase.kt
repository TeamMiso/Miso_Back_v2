package andreas311.miso.domain.recyclables.application.port.input

import andreas311.miso.domain.recyclables.application.port.input.dto.ListRecyclablesDto

interface ListRecyclablesUseCase {
    fun execute(): ListRecyclablesDto
}