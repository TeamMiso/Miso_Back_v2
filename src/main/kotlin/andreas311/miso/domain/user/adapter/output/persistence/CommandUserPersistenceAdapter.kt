package andreas311.miso.domain.user.adapter.output.persistence

import andreas311.miso.domain.user.adapter.output.persistence.mapper.UserMapper
import andreas311.miso.domain.user.adapter.output.persistence.repository.UserRepository
import andreas311.miso.domain.user.application.port.output.CommandUserPort
import andreas311.miso.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
class CommandUserPersistenceAdapter(
    private val userMapper: UserMapper,
    private val userRepository: UserRepository
) : CommandUserPort {
    override fun saveUser(user: User): User {
        val userEntity = userRepository.save(userMapper toEntity user)
        return userMapper.toDomain(userEntity)!!
    }

    override fun deleteByEmail(email: String) {
        val userEntity = userRepository.findByEmail(email)
        return userEntity?.let { userRepository.delete(it) }!!
    }
}