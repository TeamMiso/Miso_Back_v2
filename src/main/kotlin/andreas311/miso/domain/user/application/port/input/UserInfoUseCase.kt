package andreas311.miso.domain.user.application.port.input

import andreas311.miso.domain.user.application.port.input.dto.UserInfoDto

interface UserInfoUseCase {
    fun execute(): UserInfoDto
}