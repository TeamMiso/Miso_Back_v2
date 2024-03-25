package andreas311.miso.domain.purchase.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.auth.application.port.output.UserSecurityPort
import andreas311.miso.domain.item.application.exception.ItemNotFoundException
import andreas311.miso.domain.item.application.port.output.CommandItemPort
import andreas311.miso.domain.item.application.port.output.QueryItemPort
import andreas311.miso.domain.purchase.application.exception.ItemSoldOutException
import andreas311.miso.domain.purchase.application.exception.PointNotEnoughException
import andreas311.miso.domain.purchase.application.port.input.PurchaseItemUseCase
import andreas311.miso.domain.purchase.application.port.output.CommandPurchasePort
import andreas311.miso.domain.purchase.domain.Purchase
import andreas311.miso.domain.user.application.port.output.CommandUserPort
import java.time.LocalDateTime

@RollbackService
class PurchaseItemService(
    private val queryItemPort: QueryItemPort,
    private val commandItemPort: CommandItemPort,
    private val commandUserPort: CommandUserPort,
    private val userSecurityPort: UserSecurityPort,
    private val commandPurchasePort: CommandPurchasePort
) : PurchaseItemUseCase {
    override fun execute(id: Long) {
        val user = userSecurityPort.currentUser()

        val item = queryItemPort.findByIdOrNull(id)
            ?: throw ItemNotFoundException()

        if (item.amount == 0) {
            throw ItemSoldOutException()
        }

        if (item.price > user.point) {
            throw PointNotEnoughException()
        }

        commandItemPort.saveItem(item.removeAmount())

        commandUserPort.saveUser(user.removePoint(item.price))

        commandPurchasePort.savePurchase(
            Purchase(
                id = 0L,
                user = user,
                item = item,
                createdDate = LocalDateTime.now()
            )
        )
    }
}