package andreas311.miso.domain.auth.application.port.output.dto

import java.time.ZonedDateTime

data class TokenDto(
    val accessToken: String,
    val refreshToken: String,
    val accessExp: ZonedDateTime,
    val refreshExp: ZonedDateTime
)
