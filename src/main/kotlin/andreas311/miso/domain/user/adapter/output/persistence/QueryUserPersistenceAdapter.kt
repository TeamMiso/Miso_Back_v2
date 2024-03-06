package andreas311.miso.domain.user.adapter.output.persistence

import andreas311.miso.domain.user.adapter.output.persistence.mapper.UserMapper
import andreas311.miso.domain.user.adapter.output.persistence.repository.UserRepository
import andreas311.miso.domain.user.application.port.output.QueryUserPort
import andreas311.miso.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
class QueryUserPersistenceAdapter(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
): QueryUserPort {
    override fun findByEmailOrNull(email: String): User? {
        val userEntity = userRepository.findByEmail(email)
        return userMapper.toDomain(userEntity)
    }
}