package andreas311.miso.domain.email.adapter.output.persistence.repository

import andreas311.miso.domain.email.adapter.output.persistence.entity.EmailEntity
import org.springframework.data.repository.CrudRepository

interface EmailRepository : CrudRepository<EmailEntity, Long> {
    fun findByEmail(email: String): EmailEntity
    fun existsByEmail(email: String): Boolean
    fun findByRandomKey(randomKey: String): EmailEntity?
}