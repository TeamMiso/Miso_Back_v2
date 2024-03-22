package andreas311.miso.domain.auth.adapter.output.persistence.repository

import andreas311.miso.domain.auth.adapter.output.persistence.entity.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, String> {
    fun findByUserId(userId: UUID): RefreshTokenEntity?
}