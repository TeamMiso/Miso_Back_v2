package andreas311.miso.domain.purchase.domain

import andreas311.miso.domain.item.domain.Item
import andreas311.miso.domain.user.domain.User
import java.time.LocalDateTime

data class Purchase(
    val id: Long,
    val user: User,
    val item: Item,
    val createdDate: LocalDateTime
)
