package andreas311.miso.domain.purchase.application.port.output

import andreas311.miso.domain.purchase.domain.Purchase

interface CommandPurchasePort {
    fun savePurchase(purchase: Purchase): Purchase
}