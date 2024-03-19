package andreas311.miso.domain.auth.application.port.input

import andreas311.miso.domain.auth.application.port.output.dto.TokenDto

interface TokenReissueUseCase {
    fun execute(refreshToken: String): TokenDto
}