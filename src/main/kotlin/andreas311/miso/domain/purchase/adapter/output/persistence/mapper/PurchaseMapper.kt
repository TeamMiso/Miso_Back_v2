package andreas311.miso.domain.purchase.adapter.output.persistence.mapper

import andreas311.miso.domain.item.adapter.output.persistence.mapper.ItemMapper
import andreas311.miso.domain.purchase.adapter.output.persistence.entity.PurchaseEntity
import andreas311.miso.domain.purchase.domain.Purchase
import andreas311.miso.domain.user.adapter.output.persistence.mapper.UserMapper
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val userMapper: UserMapper,
    private val itemMapper: ItemMapper
) {
    infix fun toEntity(domain: Purchase): PurchaseEntity =
        PurchaseEntity(
            id = domain.id,
            user = userMapper toEntity domain.user,
            item = itemMapper toEntity domain.item,
            createdDate = domain.createdDate
        )

    infix fun toDomain(entity: PurchaseEntity?): Purchase? =
        entity?.let {
            Purchase(
                id = entity.id,
                user = userMapper.toDomain(it.user)!!,
                item = itemMapper.toDomain(it.item)!!,
                createdDate = entity.createdDate
            )
        }
}