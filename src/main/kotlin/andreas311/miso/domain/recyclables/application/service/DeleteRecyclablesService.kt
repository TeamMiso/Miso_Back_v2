package andreas311.miso.domain.recyclables.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.recyclables.application.exception.RecyclablesNotFoundException
import andreas311.miso.domain.recyclables.application.port.input.DeleteRecyclablesUseCase
import andreas311.miso.domain.recyclables.application.port.output.CommandRecyclablesPort
import andreas311.miso.domain.recyclables.application.port.output.QueryRecyclablesPort
import org.springframework.cache.annotation.CacheEvict

@RollbackService
class DeleteRecyclablesService(
    private val queryRecyclablesPort: QueryRecyclablesPort,
    private val commandRecyclablesPort: CommandRecyclablesPort
) : DeleteRecyclablesUseCase {
    @CacheEvict(cacheNames = ["recyclables"], key = "#id", cacheManager = "redisCacheManager")
    override fun execute(id: Long) {
        val recyclablesEntity = queryRecyclablesPort.findByIdOrNull(id)
            ?: throw RecyclablesNotFoundException()

        commandRecyclablesPort.deleteRecyclables(recyclablesEntity)
    }

}