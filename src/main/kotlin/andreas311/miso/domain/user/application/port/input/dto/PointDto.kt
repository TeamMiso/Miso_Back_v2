package andreas311.miso.domain.user.application.port.input.dto

import andreas311.miso.domain.user.domain.User

data class PointDto(
    val point: Int = 0
) {
    constructor(user: User) : this(
        point = user.point
    )
}
