package andreas311.miso.domain.user.application.port.input.dto

import andreas311.miso.domain.user.domain.Role

data class EditUserInfoDto(
    val email: String,
    val point: Int,
    val role: Role
)
