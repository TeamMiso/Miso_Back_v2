package andreas311.miso.domain.item.application.port.input

import andreas311.miso.domain.item.application.port.input.dto.ListItemDto

interface ListItemUseCase {
    fun execute(): ListItemDto
}