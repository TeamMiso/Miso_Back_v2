package andreas311.miso.domain.item.application.service

import andreas311.miso.common.annotation.ReadOnlyRollbackService
import andreas311.miso.domain.item.application.exception.ItemNotFoundException
import andreas311.miso.domain.item.application.port.input.DetailItemUseCase
import andreas311.miso.domain.item.application.port.input.dto.DetailItemDto
import andreas311.miso.domain.item.application.port.output.QueryItemPort

@ReadOnlyRollbackService
class DetailItemService(
    private val queryItemPort: QueryItemPort
): DetailItemUseCase {
    override fun execute(id: Long): DetailItemDto {
        val item = queryItemPort.findByIdOrNull(id)
            ?: throw ItemNotFoundException()

        return DetailItemDto(item)
    }
}