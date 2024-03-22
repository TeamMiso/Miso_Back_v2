package andreas311.miso.domain.item.application.port.input

import andreas311.miso.domain.item.application.port.input.dto.CreateItemDto
import org.springframework.web.multipart.MultipartFile

interface CreateItemUseCase {
    fun execute(createItemDto: CreateItemDto, multipartFile: MultipartFile?)
}