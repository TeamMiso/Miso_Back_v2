package andreas311.miso.domain.auth.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.auth.application.exception.UserAlreadyExistException
import andreas311.miso.domain.auth.application.port.input.SignUpUseCase
import andreas311.miso.domain.auth.application.port.input.dto.SignUpDto
import andreas311.miso.domain.auth.application.port.output.PasswordEncodePort
import andreas311.miso.domain.email.application.port.output.CommandEmailPort
import andreas311.miso.domain.email.application.port.output.EmailSendPort
import andreas311.miso.domain.email.application.port.output.QueryEmailPort
import andreas311.miso.domain.user.application.port.output.CommandUserPort
import andreas311.miso.domain.user.application.port.output.QueryUserPort
import andreas311.miso.domain.user.domain.Role
import andreas311.miso.domain.user.domain.User
import java.util.*

@RollbackService
class SignUpService(
    private val queryUserPort: QueryUserPort,
    private val emailSendPort: EmailSendPort,
    private val queryEmailPort: QueryEmailPort,
    private val commandUserPort: CommandUserPort,
    private val commandEmailPort: CommandEmailPort,
    private val passwordEncodePort: PasswordEncodePort
) : SignUpUseCase {
    override fun execute(signUpDto: SignUpDto) {
        passwordEncodePort.isPasswordMatch(signUpDto.password, signUpDto.passwordCheck)

        if (!queryUserPort.existsByEmail(signUpDto.email)) {
            emailSendPort.sendEmailAuthKey(signUpDto.email)
        }

        val email = queryEmailPort.findByEmailOrNull(signUpDto.email)

        if (queryUserPort.existsByEmail(signUpDto.email)) {
            when {
                email!!.authentication -> throw UserAlreadyExistException()
                else -> {
                    commandUserPort.deleteByEmail(signUpDto.email)
                    commandEmailPort.deleteByEmail(signUpDto.email)
                    emailSendPort.sendEmailAuthKey(signUpDto.email)
                }
            }
        }

        val user = User(
            id = UUID.randomUUID(),
            email = signUpDto.email,
            password = passwordEncodePort.passwordEncode(signUpDto.password),
            point = 0,
            role = mutableListOf(Role.ROLE_USER),
        )

        commandUserPort.saveUser(user)
    }
}