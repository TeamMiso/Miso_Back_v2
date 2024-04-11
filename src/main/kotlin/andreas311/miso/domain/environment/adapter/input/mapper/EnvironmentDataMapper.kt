package andreas311.miso.domain.environment.adapter.input.mapper

import andreas311.miso.domain.environment.adapter.input.data.request.CreateEnvironmentRequest
import andreas311.miso.domain.environment.adapter.input.data.request.EditEnvironmentRequest
import andreas311.miso.domain.environment.adapter.input.data.response.DetailEnvironmentResponse
import andreas311.miso.domain.environment.application.port.input.dto.CreateEnvironmentDto
import andreas311.miso.domain.environment.application.port.input.dto.DetailEnvironmentDto
import andreas311.miso.domain.environment.application.port.input.dto.EditEnvironmentDto
import org.springframework.stereotype.Component

@Component
class EnvironmentDataMapper {
    infix fun toDto(createEnvironmentRequest: CreateEnvironmentRequest): CreateEnvironmentDto =
        CreateEnvironmentDto(
            title = createEnvironmentRequest.title,
            content = createEnvironmentRequest.content
        )

    infix fun toDto(editEnvironmentRequest: EditEnvironmentRequest): EditEnvironmentDto =
        EditEnvironmentDto(
            title = editEnvironmentRequest.title,
            content = editEnvironmentRequest.content
        )

    fun toResponse(detailEnvironmentDto: DetailEnvironmentDto): DetailEnvironmentResponse =
        DetailEnvironmentResponse(
            title = detailEnvironmentDto.title,
            content = detailEnvironmentDto.content,
            imageUrl = detailEnvironmentDto.imageUrl
        )
}