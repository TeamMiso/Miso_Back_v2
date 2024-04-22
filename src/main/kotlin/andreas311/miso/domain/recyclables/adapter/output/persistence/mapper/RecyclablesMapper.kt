package andreas311.miso.domain.recyclables.adapter.output.persistence.mapper

import andreas311.miso.domain.recyclables.adapter.output.persistence.entity.RecyclablesEntity
import andreas311.miso.domain.recyclables.domain.Recyclables
import org.springframework.stereotype.Component

@Component
class RecyclablesMapper {
    infix fun toEntity(domain: Recyclables): RecyclablesEntity =
        RecyclablesEntity(
            id = domain.id,
            title = domain.title,
            subTitle = domain.subTitle,
            recycleMethod = domain.recycleMethod,
            recycleTip = domain.recycleTip,
            recycleCaution = domain.recycleCaution,
            imageUrl = domain.imageUrl,
            recyclablesType = domain.recyclablesType,
            recycleMark = domain.recycleMark
        )

    infix fun toDomain(entity: RecyclablesEntity?): Recyclables? =
        entity?.let {
            Recyclables(
                id = entity.id,
                title = entity.title,
                subTitle = entity.subTitle,
                recycleMethod = entity.recycleMethod,
                recycleTip = entity.recycleTip,
                recycleCaution = entity.recycleCaution,
                imageUrl = entity.imageUrl,
                recyclablesType = entity.recyclablesType,
                recycleMark = entity.recycleMark
            )
        }
}