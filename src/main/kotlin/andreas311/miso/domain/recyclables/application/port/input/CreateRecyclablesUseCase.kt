package andreas311.miso.domain.recyclables.application.port.input

import andreas311.miso.domain.recyclables.application.port.input.dto.CreateRecyclablesDto
import org.springframework.web.multipart.MultipartFile

interface CreateRecyclablesUseCase {
    fun execute(createRecyclablesDto: CreateRecyclablesDto, multipartFile: MultipartFile?)
}