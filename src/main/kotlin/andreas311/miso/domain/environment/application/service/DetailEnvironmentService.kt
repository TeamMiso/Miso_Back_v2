package andreas311.miso.domain.environment.application.service

import andreas311.miso.common.annotation.ReadOnlyRollbackService
import andreas311.miso.domain.environment.application.port.input.DetailEnvironmentUseCase
import andreas311.miso.domain.environment.application.port.input.dto.DetailEnvironmentDto
import andreas311.miso.domain.environment.application.port.output.QueryTodayEnvironmentPort
import org.springframework.cache.annotation.Cacheable

@ReadOnlyRollbackService
class DetailEnvironmentService(
    private val queryTodayEnvironmentPort: QueryTodayEnvironmentPort
) : DetailEnvironmentUseCase {
    @Cacheable(cacheNames = ["environment"], key = "'todayEnvironment'", cacheManager = "redisCacheManager")
    override fun execute(): DetailEnvironmentDto {
        val environment = queryTodayEnvironmentPort.findOne()

        return DetailEnvironmentDto(environment)
    }
}