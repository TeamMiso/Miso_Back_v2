package andreas311.miso.domain.recyclables.application.port.input

import andreas311.miso.domain.recyclables.application.port.input.dto.ListDetailRecyclablesDto
import org.springframework.web.multipart.MultipartFile

interface ProcessRecyclablesUseCase {
    suspend fun execute(multipartFile: MultipartFile): ListDetailRecyclablesDto
}