package andreas311.miso.domain.user.application.port.input

import andreas311.miso.domain.user.application.port.input.dto.PointDto

interface GetPointUseCase {
    fun execute(): PointDto
}