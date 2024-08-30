package andreas311.miso.domain.email.adapter.output.persistence.repository

import andreas311.miso.domain.email.adapter.output.persistence.entity.EmailEntity
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import javax.persistence.LockModeType

interface EmailRepository : CrudRepository<EmailEntity, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT e FROM EmailEntity e WHERE e.email = :email")
    fun findByEmail(email: String): EmailEntity
    fun existsByEmail(email: String): Boolean
    fun findByRandomKey(randomKey: String): EmailEntity?
}