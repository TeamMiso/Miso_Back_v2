package andreas311.miso.domain.auth.application.port.output.dto

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class TokenDto(
    val accessToken: String,
    val refreshToken: String,
    val accessExp: Long,
    val refreshExp: Long
) {
    override fun toString(): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
        return "{" +
            "\"accessToken\":" + "\"" + this.accessToken + "\"," +
            "\"refreshToken\":" + "\"" + this.refreshToken + "\"," +
            "\"accessTokenExpiredAt\":" + "\"" + LocalDateTime.now().plusSeconds(this.accessExp).format(formatter) + "\"," +
            "\"refreshTokenExpiredAt\":" + "\"" + LocalDateTime.now().plusSeconds(this.refreshExp).format(formatter) + "\"}"
    }
}
