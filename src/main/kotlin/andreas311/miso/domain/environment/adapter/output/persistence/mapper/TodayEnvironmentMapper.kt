package andreas311.miso.domain.environment.adapter.output.persistence.mapper

import andreas311.miso.domain.environment.adapter.output.persistence.entity.TodayEnvironmentEntity
import andreas311.miso.domain.environment.domain.TodayEnvironment
import org.springframework.stereotype.Component

@Component
class TodayEnvironmentMapper {
    infix fun toEntity(domain: TodayEnvironment): TodayEnvironmentEntity =
        TodayEnvironmentEntity(
            id = domain.id,
            title = domain.title,
            content = domain.content,
            imageUrl = domain.imageUrl
        )

    infix fun toDomain(entity: TodayEnvironmentEntity?): TodayEnvironment? =
        entity?.let {
            TodayEnvironment(
                id = entity.id,
                title = entity.title,
                content = entity.content,
                imageUrl = entity.imageUrl
            )
        }
}