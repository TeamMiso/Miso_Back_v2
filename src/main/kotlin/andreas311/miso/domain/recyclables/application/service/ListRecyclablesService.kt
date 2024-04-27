package andreas311.miso.domain.recyclables.application.service

import andreas311.miso.common.annotation.ReadOnlyRollbackService
import andreas311.miso.domain.recyclables.application.port.input.ListRecyclablesUseCase
import andreas311.miso.domain.recyclables.application.port.input.dto.ListRecyclablesDto
import andreas311.miso.domain.recyclables.application.port.input.dto.RecyclablesDto
import andreas311.miso.domain.recyclables.application.port.output.QueryRecyclablesPort
import org.springframework.cache.annotation.Cacheable

@ReadOnlyRollbackService
class ListRecyclablesService(
    private val queryRecyclablesPort: QueryRecyclablesPort
) : ListRecyclablesUseCase {
    @Cacheable(cacheNames = ["recyclablesList"], key = "'recyclablesList'", cacheManager = "redisCacheManager")
    override fun execute(): ListRecyclablesDto {
        return ListRecyclablesDto(
            recyclablesList = queryRecyclablesPort.findAll()
                .map { RecyclablesDto(it) }
        )
    }
}