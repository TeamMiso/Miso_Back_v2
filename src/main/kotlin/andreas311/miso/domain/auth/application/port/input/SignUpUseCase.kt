package andreas311.miso.domain.auth.application.port.input

import andreas311.miso.domain.auth.application.port.input.dto.SignUpDto

interface SignUpUseCase {
    fun execute(signUpDto: SignUpDto)
}