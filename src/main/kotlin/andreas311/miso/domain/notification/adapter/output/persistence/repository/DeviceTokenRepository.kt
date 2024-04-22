package andreas311.miso.domain.notification.adapter.output.persistence.repository

import andreas311.miso.domain.notification.adapter.output.persistence.entity.DeviceTokenEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface DeviceTokenRepository : CrudRepository<DeviceTokenEntity, String> {
    fun findByUserId(userId: UUID): DeviceTokenEntity?
}