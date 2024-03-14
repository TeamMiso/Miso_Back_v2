package andreas311.miso.domain.auth.adapter.input.mapper

import andreas311.miso.domain.auth.adapter.input.data.request.SignUpRequest
import andreas311.miso.domain.auth.application.port.input.dto.SignUpDto
import org.springframework.stereotype.Component

@Component
class AuthDataMapper {
    infix fun toDto(signUpRequest: SignUpRequest): SignUpDto =
        SignUpDto(
            email = signUpRequest.email,
            password = signUpRequest.password,
            passwordCheck = signUpRequest.passwordCheck
        )
}
