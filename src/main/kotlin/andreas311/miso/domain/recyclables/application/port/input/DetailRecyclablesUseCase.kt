package andreas311.miso.domain.recyclables.application.port.input

import andreas311.miso.domain.recyclables.application.port.input.dto.DetailRecyclablesDto
import andreas311.miso.domain.recyclables.domain.RecyclablesType

interface DetailRecyclablesUseCase {
    fun execute(recyclablesType: RecyclablesType): DetailRecyclablesDto
}