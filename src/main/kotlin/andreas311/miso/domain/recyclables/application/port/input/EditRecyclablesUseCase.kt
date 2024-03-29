package andreas311.miso.domain.recyclables.application.port.input

import andreas311.miso.domain.recyclables.application.port.input.dto.EditRecyclablesDto
import org.springframework.web.multipart.MultipartFile

interface EditRecyclablesUseCase {
    fun execute(id: Long, editRecyclablesDto: EditRecyclablesDto, multipartFile: MultipartFile?)
}