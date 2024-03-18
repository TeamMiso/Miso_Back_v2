package andreas311.miso.domain.auth.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.auth.application.port.input.LogoutUseCase
import andreas311.miso.domain.auth.application.port.output.CommandRefreshTokenPort
import andreas311.miso.domain.auth.application.port.output.QueryRefreshTokenPort
import andreas311.miso.domain.auth.application.port.output.UserSecurityPort
import andreas311.miso.domain.user.application.exception.UserNotFoundException

@RollbackService
class LogoutService(
    private val userSecurityPort: UserSecurityPort,
    private val queryRefreshTokenPort: QueryRefreshTokenPort,
    private val commandRefreshTokenPort: CommandRefreshTokenPort
): LogoutUseCase {
    override fun execute() {
        val user = userSecurityPort.currentUser()

        val refreshTokenEntity = queryRefreshTokenPort.findByUserIdOrNull(user.id)
            ?: throw UserNotFoundException()

        commandRefreshTokenPort.deleteRefreshToken(refreshTokenEntity)
    }
}