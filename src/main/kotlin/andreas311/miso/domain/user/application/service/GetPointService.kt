package andreas311.miso.domain.user.application.service

import andreas311.miso.common.annotation.ReadOnlyRollbackService
import andreas311.miso.domain.auth.application.port.output.UserSecurityPort
import andreas311.miso.domain.user.application.port.input.GetPointUseCase
import andreas311.miso.domain.user.application.port.input.dto.PointDto

@ReadOnlyRollbackService
class GetPointService(
    private val userSecurityPort: UserSecurityPort
) : GetPointUseCase {
    override fun execute(): PointDto {
        val user = userSecurityPort.currentUser()

        return PointDto(user)
    }
}