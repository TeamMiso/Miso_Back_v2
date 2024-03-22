package andreas311.miso.domain.purchase.application.service

import andreas311.miso.common.annotation.ReadOnlyRollbackService
import andreas311.miso.domain.auth.application.port.output.UserSecurityPort
import andreas311.miso.domain.purchase.application.port.input.ListMyPurchaseItemUseCase
import andreas311.miso.domain.purchase.application.port.input.dto.ListPurchaseDto
import andreas311.miso.domain.purchase.application.port.input.dto.PurchaseDto
import andreas311.miso.domain.purchase.application.port.output.QueryPurchasePort

@ReadOnlyRollbackService
class ListMyPurchaseItemService(
    private val userSecurityPort: UserSecurityPort,
    private val queryPurchasePort: QueryPurchasePort
) : ListMyPurchaseItemUseCase {
    override fun execute(): ListPurchaseDto {
        val user = userSecurityPort.currentUser()

        return ListPurchaseDto(
            purchaseList = queryPurchasePort.findAllByUser(user)
                .map { PurchaseDto(it) }
        )
    }
}
