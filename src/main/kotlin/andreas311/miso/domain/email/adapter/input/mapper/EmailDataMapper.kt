package andreas311.miso.domain.email.adapter.input.mapper

import andreas311.miso.domain.email.adapter.input.data.request.RandomKeyRequest
import andreas311.miso.domain.email.application.port.input.dto.RandomKeyDto
import org.springframework.stereotype.Component

@Component
class EmailDataMapper {
    infix fun toDto(randomKeyRequest: RandomKeyRequest): RandomKeyDto =
        RandomKeyDto(
            randomKey = randomKeyRequest.randomKey
        )
}