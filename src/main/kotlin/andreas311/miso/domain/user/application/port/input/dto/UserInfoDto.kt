package andreas311.miso.domain.user.application.port.input.dto

import andreas311.miso.domain.user.domain.Role
import andreas311.miso.domain.user.domain.User
import java.util.*

data class UserInfoDto(
    val id: UUID = UUID.randomUUID(),
    val email: String = "",
    val role: Role = Role.ROLE_USER
) {
    constructor(user: User) : this(
        id = user.id,
        email = user.email,
        role = user.role
    )
}
