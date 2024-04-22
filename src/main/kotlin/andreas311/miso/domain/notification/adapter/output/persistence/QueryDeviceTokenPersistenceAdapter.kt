package andreas311.miso.domain.notification.adapter.output.persistence

import andreas311.miso.domain.notification.adapter.output.persistence.mapper.DeviceTokenMapper
import andreas311.miso.domain.notification.adapter.output.persistence.repository.DeviceTokenRepository
import andreas311.miso.domain.notification.application.port.output.QueryDeviceTokenPort
import andreas311.miso.domain.notification.domain.DeviceToken
import org.springframework.stereotype.Component
import java.util.*

@Component
class QueryDeviceTokenPersistenceAdapter(
    private val deviceTokenMapper: DeviceTokenMapper,
    private val deviceTokenRepository: DeviceTokenRepository
) : QueryDeviceTokenPort {
    override fun findByUserIdOrNull(id: UUID): DeviceToken? {
        val deviceTokenEntity = deviceTokenRepository.findByUserId(id)
        return deviceTokenMapper toDomain deviceTokenEntity
    }

    override fun findAll(): List<DeviceToken> {
        val deviceTokenList = deviceTokenRepository.findAll()
        return deviceTokenList.map { deviceTokenMapper.toDomain(it)!! }
    }
}