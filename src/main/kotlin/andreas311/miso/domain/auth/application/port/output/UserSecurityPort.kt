package andreas311.miso.domain.auth.application.port.output

import andreas311.miso.domain.user.domain.User

interface UserSecurityPort {
    fun currentUser(): User
}