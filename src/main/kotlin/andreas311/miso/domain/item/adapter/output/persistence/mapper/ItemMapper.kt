package andreas311.miso.domain.item.adapter.output.persistence.mapper

import andreas311.miso.domain.item.adapter.output.persistence.entity.ItemEntity
import andreas311.miso.domain.item.domain.Item
import org.springframework.stereotype.Component

@Component
class ItemMapper {
    infix fun toEntity(domain: Item): ItemEntity =
        ItemEntity(
            id = domain.id,
            price = domain.price,
            amount = domain.amount,
            name = domain.name,
            content = domain.content,
            imageUrl = domain.imageUrl
        )

    infix fun toDomain(entity: ItemEntity?): Item? =
        entity?.let {
            Item(
                id = entity.id,
                price = entity.price,
                amount = entity.amount,
                name = entity.name,
                content = entity.content,
                imageUrl = entity.imageUrl
            )
        }
}