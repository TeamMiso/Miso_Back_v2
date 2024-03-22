package andreas311.miso.domain.purchase.adapter.output.persistence

import andreas311.miso.domain.purchase.adapter.output.persistence.mapper.PurchaseMapper
import andreas311.miso.domain.purchase.adapter.output.persistence.repository.PurchaseRepository
import andreas311.miso.domain.purchase.application.port.output.CommandPurchasePort
import andreas311.miso.domain.purchase.domain.Purchase
import org.springframework.stereotype.Component

@Component
class CommandPurchasePersistenceAdapter(
    private val purchaseMapper: PurchaseMapper,
    private val purchaseRepository: PurchaseRepository
) : CommandPurchasePort {
    override fun savePurchase(purchase: Purchase): Purchase {
        val purchaseEntity = purchaseRepository.save(purchaseMapper toEntity purchase)
        return purchaseMapper.toDomain(purchaseEntity)!!
    }
}