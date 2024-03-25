package andreas311.miso.domain.user.adapter.input.data.response

import andreas311.miso.domain.user.domain.Role
import java.util.*

data class UserInfoResponse(
    val id: UUID,
    val email: String,
    val role: Role
)
