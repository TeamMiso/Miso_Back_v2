package andreas311.miso.global.security.principal

import andreas311.miso.common.annotation.ReadOnlyRollbackService
import andreas311.miso.domain.user.application.exception.UserNotFoundException
import andreas311.miso.domain.user.application.port.output.QueryUserPort
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

@ReadOnlyRollbackService
class AdminDetailService(
    private val queryUserPort: QueryUserPort
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails =
        queryUserPort.findByEmailOrNull(username)
            .let { it ?: throw UserNotFoundException() }
            .let { AdminDetail(it) }
}