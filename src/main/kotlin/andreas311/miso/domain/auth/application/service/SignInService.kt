package andreas311.miso.domain.auth.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.auth.application.event.SaveRefreshTokenEvent
import andreas311.miso.domain.auth.application.exception.EmailNotValidException
import andreas311.miso.domain.auth.application.port.input.SignInUseCase
import andreas311.miso.domain.auth.application.port.input.dto.SignInDto
import andreas311.miso.domain.auth.application.port.output.TokenGeneratePort
import andreas311.miso.domain.auth.application.port.output.dto.TokenDto
import andreas311.miso.domain.email.application.port.output.QueryEmailPort
import andreas311.miso.domain.user.application.exception.UserNotFoundException
import andreas311.miso.domain.user.application.port.output.QueryUserPort
import andreas311.miso.domain.user.domain.User
import org.springframework.context.ApplicationEventPublisher

@RollbackService
class SignInService(
    private val queryUserPort: QueryUserPort,
    private val queryEmailPort: QueryEmailPort,
    private val tokenGeneratePort: TokenGeneratePort,
    private val applicationEventPublisher: ApplicationEventPublisher
): SignInUseCase {
    override fun execute(signInDto: SignInDto): TokenDto {
        val user = queryUserPort.findByEmailOrNull(signInDto.email)
            ?: throw UserNotFoundException()

        val email = queryEmailPort.findByEmailOrNull(signInDto.email)

        if (!email!!.authentication) {
            throw EmailNotValidException()
        }

        val token = tokenGeneratePort.generateToken(signInDto.email, user.role)

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