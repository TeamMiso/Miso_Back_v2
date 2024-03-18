package andreas311.miso.domain.auth.adapter.output.persistence.mapper

import andreas311.miso.domain.auth.adapter.output.persistence.entity.RefreshTokenEntity
import andreas311.miso.domain.auth.domain.RefreshToken
import org.springframework.stereotype.Component

@Component
class RefreshTokenMapper {
    infix fun toEntity(domain: RefreshToken): RefreshTokenEntity =
        RefreshTokenEntity(
            userId = domain.userId,
            refreshToken = domain.refreshToken
        )

    infix fun toDomain(entity: RefreshTokenEntity?): RefreshToken? =
        entity?.let {
            RefreshToken(
                userId = entity.userId,
                refreshToken = entity.refreshToken
            )
        }
}