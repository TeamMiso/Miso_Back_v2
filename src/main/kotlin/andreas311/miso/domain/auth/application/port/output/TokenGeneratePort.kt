package andreas311.miso.domain.auth.application.port.output

import andreas311.miso.domain.auth.application.port.output.dto.TokenDto
import andreas311.miso.domain.user.domain.Role

interface TokenGeneratePort {
    fun generateToken(email: String, role: Role): TokenDto
}