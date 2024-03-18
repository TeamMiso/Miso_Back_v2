package andreas311.miso.domain.auth.domain

import java.util.UUID

data class RefreshToken(
    val userId: UUID,
    val refreshToken: String
)
