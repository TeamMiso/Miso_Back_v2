package andreas311.miso.domain.purchase.adapter.output.persistence

import andreas311.miso.domain.purchase.adapter.output.persistence.mapper.PurchaseMapper
import andreas311.miso.domain.purchase.adapter.output.persistence.repository.PurchaseRepository
import andreas311.miso.domain.purchase.application.port.output.QueryPurchasePort
import andreas311.miso.domain.purchase.domain.Purchase
import andreas311.miso.domain.user.adapter.output.persistence.mapper.UserMapper
import andreas311.miso.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
class QueryPurchasePersistenceAdapter(
    private val userMapper: UserMapper,
    private val purchaseMapper: PurchaseMapper,
    private val purchaseRepository: PurchaseRepository
) : QueryPurchasePort {
    override fun findAllByUser(user: User): List<Purchase> {
        val purchaseList = purchaseRepository.findAllByUserOrderByCreatedDateDesc(userMapper toEntity user)
        return purchaseList.map { purchaseMapper.toDomain(it)!! }
    }
}