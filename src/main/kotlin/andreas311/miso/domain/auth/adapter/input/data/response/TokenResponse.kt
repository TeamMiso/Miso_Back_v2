package andreas311.miso.domain.auth.adapter.input.data.response

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val accessExp: ZonedDateTime,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val refreshExp: ZonedDateTime
)
