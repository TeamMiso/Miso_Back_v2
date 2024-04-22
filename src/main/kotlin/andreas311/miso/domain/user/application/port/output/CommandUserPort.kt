package andreas311.miso.domain.user.application.port.output

import andreas311.miso.domain.user.domain.User

interface CommandUserPort {
    fun saveUser(user: User): User

    fun deleteByEmail(email: String)
}