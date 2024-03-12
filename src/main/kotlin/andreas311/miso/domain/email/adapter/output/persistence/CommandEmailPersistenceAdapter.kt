package andreas311.miso.domain.email.adapter.output.persistence

import andreas311.miso.domain.email.adapter.output.persistence.mapper.EmailMapper
import andreas311.miso.domain.email.adapter.output.persistence.repository.EmailRepository
import andreas311.miso.domain.email.application.port.output.CommandEmailPort
import andreas311.miso.domain.email.domain.Email

class CommandEmailPersistenceAdapter(
    private val emailRepository: EmailRepository,
    private val emailMapper: EmailMapper
): CommandEmailPort {
    override fun saveEmail(email: Email): Email {
        val email = emailRepository.save(emailMapper.toEntity(email))
        return emailMapper.toDomain(email)!!
    }
}