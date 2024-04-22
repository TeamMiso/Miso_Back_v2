package andreas311.miso.domain.email.adapter.output.persistence

import andreas311.miso.domain.email.adapter.output.persistence.mapper.EmailMapper
import andreas311.miso.domain.email.adapter.output.persistence.repository.EmailRepository
import andreas311.miso.domain.email.application.port.output.QueryEmailPort
import andreas311.miso.domain.email.domain.Email
import org.springframework.stereotype.Component

@Component
class QueryEmailPersistenceAdapter(
    private val emailRepository: EmailRepository,
    private val emailMapper: EmailMapper
) : QueryEmailPort {
    override fun findByEmailOrNull(email: String): Email? {
        val emailEntity = emailRepository.findByEmail(email)
        return emailMapper toDomain emailEntity
    }

    override fun existsByEmail(email: String): Boolean =
        emailRepository.existsByEmail(email)

    override fun findByRandomKeyOrNull(randomKey: String): Email? {
        val emailEntity = emailRepository.findByRandomKey(randomKey)
        return emailMapper toDomain emailEntity
    }
}