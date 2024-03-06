package andreas311.miso.domain.auth.application.port.output

import org.springframework.security.core.Authentication
import javax.servlet.http.HttpServletRequest

interface TokenParsePort {
    fun parseAccessToken(request: HttpServletRequest): String?
    fun parseRefreshTokenToken(refreshToken: String): String?
    fun authentication(token: String): Authentication
}