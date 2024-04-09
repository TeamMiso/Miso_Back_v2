package andreas311.miso.domain.environment.application.port.input

import andreas311.miso.domain.environment.application.port.input.dto.EditEnvironmentDto
import org.springframework.web.multipart.MultipartFile

interface EditEnvironmentUseCase {
    fun execute(id: Long, editEnvironmentDto: EditEnvironmentDto, multipartFile: MultipartFile?)
}