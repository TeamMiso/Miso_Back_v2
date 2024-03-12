package andreas311.miso.domain.email.adapter.output.persistence.repository

import andreas311.miso.domain.email.adapter.output.persistence.entity.EmailEntity
import org.springframework.data.repository.CrudRepository

interface EmailRepository: CrudRepository<EmailEntity, Long>