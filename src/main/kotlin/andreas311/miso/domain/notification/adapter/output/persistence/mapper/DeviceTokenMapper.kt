package andreas311.miso.domain.notification.adapter.output.persistence.mapper

import andreas311.miso.domain.notification.adapter.output.persistence.entity.DeviceTokenEntity
import andreas311.miso.domain.notification.domain.DeviceToken
import org.springframework.stereotype.Component

@Component
class DeviceTokenMapper {
    infix fun toEntity(domain: DeviceToken): DeviceTokenEntity =
        DeviceTokenEntity(
            userId = domain.userId,
            deviceToken = domain.deviceToken
        )

    infix fun toDomain(entity: DeviceTokenEntity?): DeviceToken? =
        entity?.let {
            DeviceToken(
                userId = entity.userId,
                deviceToken = entity.deviceToken
            )
        }
}