package andreas311.miso.domain.auth.application.port.output

import andreas311.miso.domain.auth.domain.RefreshToken

interface CommandRefreshTokenPort {
    fun saveRefreshToken(refreshToken: RefreshToken): String

    fun deleteRefreshToken(refreshToken: RefreshToken)
}