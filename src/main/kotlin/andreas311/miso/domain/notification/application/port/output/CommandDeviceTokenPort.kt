package andreas311.miso.domain.notification.application.port.output

import andreas311.miso.domain.notification.domain.DeviceToken

interface CommandDeviceTokenPort {
    fun saveDeviceToken(deviceToken: DeviceToken): DeviceToken
    fun deleteDeviceToken(deviceToken: DeviceToken)
}