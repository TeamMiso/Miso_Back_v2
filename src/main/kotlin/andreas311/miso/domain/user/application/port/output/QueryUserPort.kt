package andreas311.miso.domain.user.application.port.output

import andreas311.miso.domain.user.domain.User
import java.util.UUID

interface QueryUserPort {
    fun findByEmailOrNull(email: String): User?

    fun existsByEmail(email: String): Boolean

    fun findByIdOrNull(id: UUID): User?
}