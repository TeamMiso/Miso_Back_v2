package andreas311.miso.domain.item.application.port.input.dto

import andreas311.miso.domain.item.domain.Item

data class DetailItemDto(
    val id: Long,
    val price: Int,
    val amount: Int,
    val name: String,
    val content: String,
    val imageUrl: String?
) {
    constructor(item: Item) : this(
        id = item.id,
        price = item.price,
        amount = item.amount,
        name = item.name,
        content = item.content,
        imageUrl = item.imageUrl
    )

    constructor() : this(
        id = 0,
        price = 0,
        amount = 0,
        name = "",
        content = "",
        imageUrl = null
    )
}
