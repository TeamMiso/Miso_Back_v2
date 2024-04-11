package andreas311.miso.domain.notification.adapter.output.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed
import java.util.*

@RedisHash(value = "deviceToken")
data class DeviceTokenEntity(
    @Indexed
    val userId: UUID,

    @Id
    @Indexed
    val deviceToken: String
)
