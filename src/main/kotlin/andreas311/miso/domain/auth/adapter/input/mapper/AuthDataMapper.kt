package andreas311.miso.domain.auth.adapter.input.mapper

import andreas311.miso.domain.auth.adapter.input.data.request.SignInRequest
import andreas311.miso.domain.auth.adapter.input.data.request.SignUpRequest
import andreas311.miso.domain.auth.adapter.input.data.response.TokenResponse
import andreas311.miso.domain.auth.application.port.input.dto.SignInDto
import andreas311.miso.domain.auth.application.port.input.dto.SignUpDto
import andreas311.miso.domain.auth.application.port.output.dto.TokenDto
import org.springframework.stereotype.Component

@Component
class AuthDataMapper {
    infix fun toDto(signUpRequest: SignUpRequest): SignUpDto =
        SignUpDto(
            email = signUpRequest.email,
            password = signUpRequest.password,
            passwordCheck = signUpRequest.passwordCheck
        )

    infix fun toDto(signInRequest: SignInRequest): SignInDto =
        SignInDto(
            email = signInRequest.email,
            password = signInRequest.password
        )

    infix fun toResponse(tokenDto: TokenDto): TokenResponse =
        TokenResponse(
            accessToken = tokenDto.accessToken,
            refreshToken = tokenDto.refreshToken,
            accessExp = tokenDto.accessExp,
            refreshExp = tokenDto.refreshExp
        )
}
