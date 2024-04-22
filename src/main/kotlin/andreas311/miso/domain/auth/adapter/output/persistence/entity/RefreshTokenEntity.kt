package andreas311.miso.domain.auth.adapter.output.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed
import java.util.*

@RedisHash(value = "refreshToken", timeToLive = 60L * 60 * 24 * 7)
data class RefreshTokenEntity(
    @Indexed
    val userId: UUID,

    @Id
    @Indexed
    val refreshToken: String
)