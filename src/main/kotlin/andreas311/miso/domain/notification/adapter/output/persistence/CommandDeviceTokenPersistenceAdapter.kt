package andreas311.miso.domain.notification.adapter.output.persistence

import andreas311.miso.domain.notification.adapter.output.persistence.mapper.DeviceTokenMapper
import andreas311.miso.domain.notification.adapter.output.persistence.repository.DeviceTokenRepository
import andreas311.miso.domain.notification.application.port.output.CommandDeviceTokenPort
import andreas311.miso.domain.notification.domain.DeviceToken
import org.springframework.stereotype.Component

@Component
class CommandDeviceTokenPersistenceAdapter(
    private val deviceTokenMapper: DeviceTokenMapper,
    private val deviceTokenRepository: DeviceTokenRepository
) : CommandDeviceTokenPort {
    override fun saveDeviceToken(deviceToken: DeviceToken): DeviceToken {
        val deviceTokenEntity = deviceTokenRepository.save(deviceTokenMapper toEntity deviceToken)
        return deviceTokenMapper.toDomain(deviceTokenEntity)!!
    }

    override fun deleteDeviceToken(deviceToken: DeviceToken) {
        val deviceTokenEntity = deviceTokenMapper toEntity deviceToken
        return deviceTokenRepository.delete(deviceTokenEntity)
    }
}