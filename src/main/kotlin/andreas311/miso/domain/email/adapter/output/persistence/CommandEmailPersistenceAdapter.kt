package andreas311.miso.domain.email.adapter.output.persistence

import andreas311.miso.domain.email.adapter.output.persistence.mapper.EmailMapper
import andreas311.miso.domain.email.adapter.output.persistence.repository.EmailRepository
import andreas311.miso.domain.email.application.port.output.CommandEmailPort
import andreas311.miso.domain.email.domain.Email
import org.springframework.stereotype.Component

@Component
class CommandEmailPersistenceAdapter(
    private val emailMapper: EmailMapper,
    private val emailRepository: EmailRepository
) : CommandEmailPort {
    override fun saveEmail(email: Email): Email {
        val emailEntity = emailRepository.save(emailMapper toEntity email)
        return emailMapper.toDomain(emailEntity)!!
    }

    override fun deleteByEmail(email: String) {
        val emailEntity = emailRepository.findByEmail(email)
        return emailRepository.delete(emailEntity)
    }
}