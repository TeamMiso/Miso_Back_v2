package andreas311.miso.global.security.adapter

import andreas311.miso.domain.auth.application.port.output.UserSecurityPort
import andreas311.miso.domain.user.application.exception.UserNotFoundException
import andreas311.miso.domain.user.application.port.output.QueryUserPort
import andreas311.miso.domain.user.domain.User
import andreas311.miso.global.security.principal.AdminDetail
import andreas311.miso.global.security.principal.UserDetail
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
class UserSecurityAdapter(
    private val queryUserPort: QueryUserPort
): UserSecurityPort {
    override fun currentUser(): User {
        val email = fetchUserEmail()
        return fetchUserByEmail(email)
    }

    private fun fetchUserByEmail(email: String): User =
        queryUserPort.findByEmailOrNull(email) ?: throw UserNotFoundException()

    private fun fetchUserEmail(): String =
        when(val principal = SecurityContextHolder.getContext().authentication.principal) {
            is UserDetails -> {
                when (principal) {
                    is UserDetail -> principal.username
                    is AdminDetail -> principal.username
                    else -> throw IllegalArgumentException()
                }
            }
                else -> principal.toString()
        }
}