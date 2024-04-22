package andreas311.miso.domain.item.application.port.input

import andreas311.miso.domain.item.application.port.input.dto.EditItemDto
import org.springframework.web.multipart.MultipartFile

interface EditItemUseCase {
    fun execute(id: Long, editItemDto: EditItemDto, multipartFile: MultipartFile?)
}