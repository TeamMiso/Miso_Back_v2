package andreas311.miso.domain.user.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.auth.application.port.output.UserSecurityPort
import andreas311.miso.domain.user.application.port.input.GivePointUseCase
import andreas311.miso.domain.user.application.port.output.CommandUserPort
import org.springframework.cache.annotation.CacheEvict

@RollbackService
class GivePointService(
    private val commandUserPort: CommandUserPort,
    private val userSecurityPort: UserSecurityPort
) : GivePointUseCase {
    @CacheEvict(cacheNames = ["userPoint"], key = "'userPoint'", cacheManager = "redisCacheManager")
    override fun execute() {
        val user = userSecurityPort.currentUser()

        commandUserPort.saveUser(user.addPoint(100))
    }
}