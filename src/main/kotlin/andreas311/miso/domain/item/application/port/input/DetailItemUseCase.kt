package andreas311.miso.domain.item.application.port.input

import andreas311.miso.domain.item.application.port.input.dto.DetailItemDto

interface DetailItemUseCase {
    fun execute(id: Long): DetailItemDto
}