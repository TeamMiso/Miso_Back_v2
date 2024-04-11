package andreas311.miso.domain.environment.application.service

import andreas311.miso.common.annotation.ReadOnlyRollbackService
import andreas311.miso.domain.environment.application.port.input.DetailEnvironmentUseCase
import andreas311.miso.domain.environment.application.port.input.dto.DetailEnvironmentDto
import andreas311.miso.domain.environment.application.port.output.QueryTodayEnvironmentPort

@ReadOnlyRollbackService
class DetailEnvironmentService(
    private val queryTodayEnvironmentPort: QueryTodayEnvironmentPort
) : DetailEnvironmentUseCase {
    override fun execute(): DetailEnvironmentDto {
        val environment = queryTodayEnvironmentPort.findAll().first()

        return DetailEnvironmentDto(environment)
    }
}