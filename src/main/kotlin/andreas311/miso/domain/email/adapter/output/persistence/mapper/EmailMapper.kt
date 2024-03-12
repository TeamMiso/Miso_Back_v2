package andreas311.miso.domain.email.adapter.output.persistence.mapper

import andreas311.miso.domain.email.adapter.output.persistence.entity.EmailEntity
import andreas311.miso.domain.email.domain.Email
import org.springframework.stereotype.Component

@Component
class EmailMapper {
    fun toEntity(domain: Email): EmailEntity =
        EmailEntity(
            id = domain.id,
            email = domain.email,
            randomKey = domain.randomKey,
            authentication = domain.authentication
        )

    fun toDomain(entity: EmailEntity): Email? =
        entity?.let {
            Email(
                id = entity.id,
                email = entity.email,
                randomKey = entity.randomKey,
                authentication = entity.authentication
            )
        }
}