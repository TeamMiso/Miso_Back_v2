package andreas311.miso.domain.auth.application.port.input

import andreas311.miso.domain.auth.application.port.input.dto.SignInDto
import andreas311.miso.domain.auth.application.port.output.dto.TokenDto

interface SignInUseCase {
    fun execute(signInDto: SignInDto): TokenDto
}