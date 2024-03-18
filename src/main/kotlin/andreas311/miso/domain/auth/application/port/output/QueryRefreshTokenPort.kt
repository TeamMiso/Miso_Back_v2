package andreas311.miso.domain.auth.application.port.output

import andreas311.miso.domain.auth.domain.RefreshToken

interface QueryRefreshTokenPort {
    fun findByRefreshTokenOrNull(refreshToken: String): RefreshToken?
}