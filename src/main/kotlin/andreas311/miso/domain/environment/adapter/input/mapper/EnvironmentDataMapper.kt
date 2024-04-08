package andreas311.miso.domain.environment.adapter.input.mapper

import andreas311.miso.domain.environment.adapter.input.data.request.CreateEnvironmentRequest
import andreas311.miso.domain.environment.application.port.input.dto.CreateEnvironmentDto
import org.springframework.stereotype.Component

@Component
class EnvironmentDataMapper {
    infix fun toDto(createEnvironmentRequest: CreateEnvironmentRequest): CreateEnvironmentDto =
        CreateEnvironmentDto(
            title = createEnvironmentRequest.title,
            content = createEnvironmentRequest.content
        )
}