package andreas311.miso.domain.purchase.adapter.output.persistence.repository

import andreas311.miso.domain.purchase.adapter.output.persistence.entity.PurchaseEntity
import andreas311.miso.domain.user.adapter.output.persistence.entity.UserEntity
import org.springframework.data.repository.CrudRepository

interface PurchaseRepository : CrudRepository<PurchaseEntity, Long> {
    fun findAllByUserOrderByCreatedDateDesc(userEntity: UserEntity): List<PurchaseEntity>
}