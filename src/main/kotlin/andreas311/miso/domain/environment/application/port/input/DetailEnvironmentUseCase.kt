package andreas311.miso.domain.environment.application.port.input

import andreas311.miso.domain.environment.application.port.input.dto.DetailEnvironmentDto

interface DetailEnvironmentUseCase {
    fun execute(): DetailEnvironmentDto
}