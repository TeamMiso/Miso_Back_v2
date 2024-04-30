package andreas311.miso.domain.user.application.port.input

import andreas311.miso.domain.user.application.port.input.dto.EditUserInfoDto
import java.util.UUID

interface EditUserInfoUseCase {
    fun execute(id: UUID, editUserInfoDto: EditUserInfoDto)
}