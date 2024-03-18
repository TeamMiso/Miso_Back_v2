package andreas311.miso.domain.auth.application.event

import java.util.*

data class SaveRefreshTokenEvent(
    val userId: UUID,
    val refreshToken: String
)
