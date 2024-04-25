package andreas311.miso.domain.item.application.service

import andreas311.miso.common.annotation.ReadOnlyRollbackService
import andreas311.miso.domain.item.application.port.input.ListItemUseCase
import andreas311.miso.domain.item.application.port.input.dto.ItemDto
import andreas311.miso.domain.item.application.port.input.dto.ListItemDto
import andreas311.miso.domain.item.application.port.output.QueryItemPort
import org.springframework.cache.annotation.Cacheable

@ReadOnlyRollbackService
class ListItemService(
    private val queryItemPort: QueryItemPort
) : ListItemUseCase {
    @Cacheable(cacheNames = ["itemList"], key = "'itemList'", cacheManager = "redisCacheManager")
    override fun execute(): ListItemDto {
        return ListItemDto(
            itemList = queryItemPort.findAll()
                .map { ItemDto(it) }
        )
    }
}