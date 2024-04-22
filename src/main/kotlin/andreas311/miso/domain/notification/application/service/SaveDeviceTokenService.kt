package andreas311.miso.domain.notification.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.auth.application.port.output.UserSecurityPort
import andreas311.miso.domain.notification.application.port.input.SaveDeviceTokenUseCase
import andreas311.miso.domain.notification.application.port.output.CommandDeviceTokenPort
import andreas311.miso.domain.notification.application.port.output.QueryDeviceTokenPort
import andreas311.miso.domain.notification.domain.DeviceToken

@RollbackService
class SaveDeviceTokenService(
    private val userSecurityPort: UserSecurityPort,
    private val queryDeviceTokenPort: QueryDeviceTokenPort,
    private val commandDeviceTokenPort: CommandDeviceTokenPort
) : SaveDeviceTokenUseCase {
    override fun execute(token: String) {
        val user = userSecurityPort.currentUser()

        val deviceToken = queryDeviceTokenPort.findByUserIdOrNull(user.id)

        deviceToken?.let {
            commandDeviceTokenPort.deleteDeviceToken(deviceToken)
        }

        commandDeviceTokenPort.saveDeviceToken(
            DeviceToken(
                userId = user.id,
                deviceToken = token
            )
        )
    }
}