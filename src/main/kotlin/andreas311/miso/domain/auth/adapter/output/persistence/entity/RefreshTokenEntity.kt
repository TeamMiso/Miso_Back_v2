package andreas311.miso.domain.auth.adapter.output.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import java.util.*

@RedisHash(value = "refreshToken", timeToLive = 60L * 60 * 24 * 7)
data class RefreshTokenEntity(
    val userId: UUID,

    @Id
    val refreshToken: String
)