package andreas311.miso.domain.user.adapter.output.persistence.repository

import andreas311.miso.domain.user.adapter.output.persistence.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepository: CrudRepository<UserEntity, UUID> {
    fun findByEmail(email: String): UserEntity?
}