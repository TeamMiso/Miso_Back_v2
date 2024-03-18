package andreas311.miso.domain.auth.adapter.output.persistence

import andreas311.miso.domain.auth.adapter.output.persistence.mapper.RefreshTokenMapper
import andreas311.miso.domain.auth.adapter.output.persistence.repository.RefreshTokenRepository
import andreas311.miso.domain.auth.application.port.output.CommandRefreshTokenPort
import andreas311.miso.domain.auth.domain.RefreshToken
import org.springframework.stereotype.Component

@Component
class CommandRefreshTokenPersistenceAdapter(
    private val refreshTokenMapper: RefreshTokenMapper,
    private val refreshTokenRepository: RefreshTokenRepository
): CommandRefreshTokenPort {
    override fun saveRefreshToken(refreshToken: RefreshToken): String {
        val refreshTokenEntity = refreshTokenMapper toEntity refreshToken
        return refreshTokenRepository.save(refreshTokenEntity).refreshToken
    }

    override fun deleteRefreshToken(refreshToken: RefreshToken) {
        val refreshTokenEntity = refreshTokenMapper toEntity refreshToken
        return refreshTokenRepository.delete(refreshTokenEntity)
    }
}