package andreas311.miso.domain.purchase.adapter.input.data.response

import java.time.LocalDateTime

data class PurchaseResponse(
    val id: Long,
    val price: Int,
    val name: String,
    val imageUrl: String?,
    val createdDate: LocalDateTime
)
