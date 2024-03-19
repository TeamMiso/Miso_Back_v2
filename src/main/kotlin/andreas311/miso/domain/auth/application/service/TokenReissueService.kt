package andreas311.miso.domain.auth.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.auth.application.event.SaveRefreshTokenEvent
import andreas311.miso.domain.auth.application.port.input.TokenReissueUseCase
import andreas311.miso.domain.auth.application.port.output.QueryRefreshTokenPort
import andreas311.miso.domain.auth.application.port.output.TokenGeneratePort
import andreas311.miso.domain.auth.application.port.output.TokenParsePort
import andreas311.miso.domain.auth.application.port.output.dto.TokenDto
import andreas311.miso.domain.user.application.exception.UserNotFoundException
import andreas311.miso.domain.user.application.port.output.QueryUserPort
import andreas311.miso.domain.user.domain.User
import andreas311.miso.global.security.jwt.common.exception.InvalidTokenTypeException
import andreas311.miso.global.security.jwt.common.exception.TokenExpiredException
import org.springframework.context.ApplicationEventPublisher

@RollbackService
class TokenReissueService(
    private val queryUserPort: QueryUserPort,
    private val tokenParsePort: TokenParsePort,
    private val tokenGeneratePort: TokenGeneratePort,
    private val queryRefreshTokenPort: QueryRefreshTokenPort,
    private val applicationEventPublisher: ApplicationEventPublisher
) : TokenReissueUseCase {
    override fun execute(refreshToken: String): TokenDto {
        val parsedRefreshToken = tokenParsePort.parseRefreshToken(refreshToken)
            ?: throw InvalidTokenTypeException()

        val refreshToken = queryRefreshTokenPort.findByRefreshTokenOrNull(parsedRefreshToken)
            ?: throw TokenExpiredException()

        val user = queryUserPort.findByIdOrNull(refreshToken.userId)
            ?: throw UserNotFoundException()

        val token = tokenGeneratePort.generateToken(user.email, user.role)

        publishSaveRefreshToken(token, user)

        return token
    }

    private fun publishSaveRefreshToken(token: TokenDto, user: User) {
        val saveRefreshTokenEvent = SaveRefreshTokenEvent(
            userId = user.id,
            refreshToken = token.refreshToken
        )
        applicationEventPublisher.publishEvent(saveRefreshTokenEvent)
    }
}