package andreas311.miso.global.security.jwt

import andreas311.miso.domain.auth.application.port.output.TokenParsePort
import andreas311.miso.domain.user.domain.Role
import andreas311.miso.global.security.jwt.common.exception.InvalidTokenTypeException
import andreas311.miso.global.security.jwt.common.properties.JwtProperties
import andreas311.miso.global.security.principal.AdminDetailService
import andreas311.miso.global.security.principal.UserDetailService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.security.Key
import javax.servlet.http.HttpServletRequest

@Component
class TokenParseAdapter(
    private val userDetailService: UserDetailService,
    private val adminDetailService: AdminDetailService,
    private val jwtProperties: JwtProperties
): TokenParsePort {
    override fun parseAccessToken(request: HttpServletRequest): String? =
        request.getHeader(JwtProperties.TOKEN_HEADER)
            .let { it ?: return null }
            .let { if (it.startsWith(JwtProperties.TOKEN_PREFIX)) it.replace(JwtProperties.TOKEN_PREFIX, "") else null }

    override fun parseRefreshToken(refreshToken: String): String? =
        if (refreshToken.startsWith(JwtProperties.TOKEN_PREFIX)) refreshToken.replace(JwtProperties.TOKEN_PREFIX, "") else null

    override fun authentication(token: String): Authentication =
        getAuthority(getTokenBody(token, jwtProperties.accessSecret))
            .let { UsernamePasswordAuthenticationToken(it, "", it.authorities) }

    private fun getTokenBody(token: String, secret: Key): Claims =
        Jwts.parserBuilder()
            .setSigningKey(secret)
            .build()
            .parseClaimsJws(token)
            .body

    private fun getAuthority(body: Claims): UserDetails =
        when (body.get(JwtProperties.AUTHORITY, String::class.java)) {
            Role.ROLE_USER.name -> userDetailService.loadUserByUsername(body.subject)
            Role.ROLE_ADMIN.name -> adminDetailService.loadUserByUsername(body.subject)
            else -> throw InvalidTokenTypeException()
        }
}