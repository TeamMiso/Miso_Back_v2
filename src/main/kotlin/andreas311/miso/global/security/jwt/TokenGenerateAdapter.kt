package andreas311.miso.global.security.jwt

import andreas311.miso.domain.auth.application.port.output.TokenGeneratePort
import andreas311.miso.domain.auth.application.port.output.dto.TokenDto
import andreas311.miso.domain.user.domain.Role
import andreas311.miso.global.security.jwt.common.properties.JwtProperties
import andreas311.miso.global.security.jwt.common.properties.JwtTimeProperties
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.ZonedDateTime
import java.util.*

@Component
class TokenGenerateAdapter(
    private val jwtProperties: JwtProperties,
    private val jwtTimeProperties: JwtTimeProperties
) : TokenGeneratePort {
    override fun generateToken(email: String, role: Role): TokenDto =
        TokenDto(
            accessToken = generateAccessToken(email, role),
            refreshToken = generateRefreshToken(email),
            accessExp = ZonedDateTime.now().plusSeconds(jwtTimeProperties.accessTime),
            refreshExp = ZonedDateTime.now().plusSeconds(jwtTimeProperties.refreshTime),
        )

    private fun generateAccessToken(email: String, role: Role): String =
        Jwts.builder()
            .signWith(jwtProperties.accessSecret, SignatureAlgorithm.HS256)
            .setSubject(email)
            .claim(JwtProperties.TOKEN_TYPE, JwtProperties.ACCESS)
            .claim(JwtProperties.AUTHORITY, role)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtTimeProperties.accessTime * 1000))
            .compact()

    private fun generateRefreshToken(email: String): String =
        Jwts.builder()
            .signWith(jwtProperties.refreshSecret, SignatureAlgorithm.HS256)
            .setSubject(email)
            .claim(JwtProperties.TOKEN_TYPE, JwtProperties.REFRESH)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtTimeProperties.refreshTime * 1000))
            .compact()
}