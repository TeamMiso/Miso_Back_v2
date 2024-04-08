package andreas311.miso.domain.environment.application.port.input

import andreas311.miso.domain.environment.application.port.input.dto.CreateEnvironmentDto
import org.springframework.web.multipart.MultipartFile

interface CreateEnvironmentUseCase {
    fun execute(createEnvironmentDto: CreateEnvironmentDto, multipartFile: MultipartFile?)
}