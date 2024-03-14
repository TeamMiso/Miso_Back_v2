package andreas311.miso.domain.user.application.port.output

import andreas311.miso.domain.user.domain.User

interface QueryUserPort {
    fun findByEmailOrNull(email: String): User?
    fun existsByEmail(email: String): Boolean
}