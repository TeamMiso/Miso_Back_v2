package andreas311.miso.domain.user.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.user.application.exception.UserNotFoundException
import andreas311.miso.domain.user.application.port.input.EditUserInfoUseCase
import andreas311.miso.domain.user.application.port.input.dto.EditUserInfoDto
import andreas311.miso.domain.user.application.port.output.CommandUserPort
import andreas311.miso.domain.user.application.port.output.QueryUserPort
import andreas311.miso.domain.user.domain.User
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Caching
import java.util.*

@RollbackService
class EditUserInfoService(
    private val queryUserPort: QueryUserPort,
    private val commandUserPort: CommandUserPort
) : EditUserInfoUseCase{
    @Caching(evict = [
        CacheEvict(cacheNames = ["userPoint"], key = "'userPoint'", cacheManager = "redisCacheManager"),
        CacheEvict(cacheNames = ["user"], key = "'userInfo'", cacheManager = "redisCacheManager")
    ])
    override fun execute(id: UUID, editUserInfoDto: EditUserInfoDto) {
        val user = queryUserPort.findByIdOrNull(id)
            ?: throw UserNotFoundException()

        commandUserPort.saveUser(
            User(
                id = user.id,
                email = editUserInfoDto.email,
                password = user.password,
                point = editUserInfoDto.point,
                role = editUserInfoDto.role
            )
        )
    }
}