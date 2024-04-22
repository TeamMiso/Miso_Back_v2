package andreas311.miso.domain.item.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.item.application.exception.ItemNotFoundException
import andreas311.miso.domain.item.application.port.input.DeleteItemUseCase
import andreas311.miso.domain.item.application.port.output.CommandItemPort
import andreas311.miso.domain.item.application.port.output.QueryItemPort
import org.springframework.cache.annotation.CacheEvict

@RollbackService
class DeleteItemService(
    private val queryItemPort: QueryItemPort,
    private val commandItemPort: CommandItemPort
) : DeleteItemUseCase {
    @CacheEvict(cacheNames = ["item"], key = "#id", cacheManager = "redisCacheManager")
    override fun execute(id: Long) {
        val itemEntity = queryItemPort.findByIdOrNull(id)
            ?: throw ItemNotFoundException()

        commandItemPort.deleteItem(itemEntity)
    }
}