package andreas311.miso.domain.purchase.application.port.output

import andreas311.miso.domain.purchase.domain.Purchase
import andreas311.miso.domain.user.domain.User

interface QueryPurchasePort {
    fun findAllByUser(user: User): List<Purchase>
}