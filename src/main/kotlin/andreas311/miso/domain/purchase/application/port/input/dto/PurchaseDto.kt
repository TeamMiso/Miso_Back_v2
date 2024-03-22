package andreas311.miso.domain.purchase.application.port.input.dto

import andreas311.miso.domain.purchase.domain.Purchase
import java.time.LocalDateTime

data class PurchaseDto(
    val id: Long,
    val price: Int,
    val name: String,
    val imageUrl: String?,
    val createdDate: LocalDateTime
) {
    constructor(purchase: Purchase) : this(
        id = purchase.item.id,
        price = purchase.item.price,
        name = purchase.item.name,
        imageUrl = purchase.item.imageUrl,
        createdDate = purchase.createdDate
    )
}
