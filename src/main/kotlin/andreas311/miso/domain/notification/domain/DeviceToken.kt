package andreas311.miso.domain.notification.domain

import java.util.UUID

data class DeviceToken(
    val userId: UUID,
    val deviceToken: String
)
