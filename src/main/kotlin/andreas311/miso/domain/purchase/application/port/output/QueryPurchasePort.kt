package andreas311.miso.domain.purchase.application.port.output

import andreas311.miso.domain.purchase.domain.Purchase
import andreas311.miso.domain.user.adapter.output.persistence.entity.UserEntity

interface QueryPurchasePort {
    fun findAllByUser(userEntity: UserEntity): List<Purchase>
}