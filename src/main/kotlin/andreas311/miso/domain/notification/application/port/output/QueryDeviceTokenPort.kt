package andreas311.miso.domain.notification.application.port.output

import andreas311.miso.domain.notification.domain.DeviceToken
import java.util.UUID

interface QueryDeviceTokenPort {
    fun findByUserIdOrNull(id: UUID): DeviceToken?
    fun findAll(): List<DeviceToken>
}