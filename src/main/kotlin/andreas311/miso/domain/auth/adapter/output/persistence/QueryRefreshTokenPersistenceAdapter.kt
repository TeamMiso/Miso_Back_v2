package andreas311.miso.domain.auth.adapter.output.persistence

import andreas311.miso.domain.auth.adapter.output.persistence.mapper.RefreshTokenMapper
import andreas311.miso.domain.auth.adapter.output.persistence.repository.RefreshTokenRepository
import andreas311.miso.domain.auth.application.port.output.QueryRefreshTokenPort
import andreas311.miso.domain.auth.domain.RefreshToken
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class QueryRefreshTokenPersistenceAdapter(
    private val refreshTokenMapper: RefreshTokenMapper,
    private val refreshTokenRepository: RefreshTokenRepository
): QueryRefreshTokenPort {
    override fun findByRefreshTokenOrNull(refreshToken: String): RefreshToken? {
        val refreshTokenEntity = refreshTokenRepository.findByIdOrNull(refreshToken)
        return refreshTokenMapper.toDomain(refreshTokenEntity)
    }
}