package andreas311.miso.domain.auth.application.port.output

import andreas311.miso.domain.auth.domain.RefreshToken
import java.util.UUID

interface QueryRefreshTokenPort {
    fun findByUserIdOrNull(userId: UUID): RefreshToken?

    fun findByRefreshTokenOrNull(refreshToken: String): RefreshToken?
}