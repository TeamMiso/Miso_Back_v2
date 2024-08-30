package andreas311.miso.domain.user.adapter.output.persistence.repository

import andreas311.miso.domain.user.adapter.output.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.UUID
import javax.persistence.LockModeType

interface UserRepository : CrudRepository<UserEntity, UUID> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT u FROM UserEntity u WHERE u.email = :email")
    fun findByEmail(email: String): UserEntity?
    fun existsByEmail(email: String): Boolean
}