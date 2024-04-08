package andreas311.miso.domain.environment.adapter.output.persistence.mapper

import andreas311.miso.domain.environment.adapter.output.persistence.entity.EnvironmentEntity
import andreas311.miso.domain.environment.domain.Environment
import org.springframework.stereotype.Component

@Component
class EnvironmentMapper {
    infix fun toEntity(domain: Environment): EnvironmentEntity =
        EnvironmentEntity(
            id = domain.id,
            title = domain.title,
            content = domain.content,
            imageUrl = domain.imageUrl
        )

    infix fun toDomain(entity: EnvironmentEntity?): Environment? =
        entity?.let {
            Environment(
                id = entity.id,
                title = entity.title,
                content = entity.content,
                imageUrl = entity.imageUrl
            )
        }
}