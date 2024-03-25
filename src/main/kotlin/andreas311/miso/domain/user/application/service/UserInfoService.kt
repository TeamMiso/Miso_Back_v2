package andreas311.miso.domain.user.application.service

import andreas311.miso.common.annotation.ReadOnlyRollbackService
import andreas311.miso.domain.auth.application.port.output.UserSecurityPort
import andreas311.miso.domain.user.application.port.input.UserInfoUseCase
import andreas311.miso.domain.user.application.port.input.dto.UserInfoDto

@ReadOnlyRollbackService
class UserInfoService(
    private val userSecurityPort: UserSecurityPort
) : UserInfoUseCase {
    override fun execute(): UserInfoDto {
        val user = userSecurityPort.currentUser()

        return UserInfoDto(user)
    }
}