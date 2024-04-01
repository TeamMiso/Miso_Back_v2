package andreas311.miso.domain.recyclables.application.service

import andreas311.miso.common.annotation.ReadOnlyRollbackService
import andreas311.miso.domain.recyclables.application.exception.RecyclablesNotFoundException
import andreas311.miso.domain.recyclables.application.port.input.DetailRecyclablesUseCase
import andreas311.miso.domain.recyclables.application.port.input.dto.DetailRecyclablesDto
import andreas311.miso.domain.recyclables.application.port.output.QueryRecyclablesPort
import andreas311.miso.domain.recyclables.domain.RecyclablesType

@ReadOnlyRollbackService
class DetailRecyclablesService(
    private val queryRecyclablesPort: QueryRecyclablesPort
) : DetailRecyclablesUseCase {
    override fun execute(recyclablesType: RecyclablesType): DetailRecyclablesDto {
        val recyclables = queryRecyclablesPort.findByRecyclablesTypeOrNull(recyclablesType)
            ?: throw RecyclablesNotFoundException()

        return DetailRecyclablesDto(recyclables)
    }
}