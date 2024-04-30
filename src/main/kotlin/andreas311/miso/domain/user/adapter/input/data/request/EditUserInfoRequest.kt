package andreas311.miso.domain.user.adapter.input.data.request

import andreas311.miso.domain.user.domain.Role

data class EditUserInfoRequest(
    val email: String,
    val point: Int,
    val role: Role
)
