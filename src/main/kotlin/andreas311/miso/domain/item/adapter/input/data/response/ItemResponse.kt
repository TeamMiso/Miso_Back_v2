package andreas311.miso.domain.item.adapter.input.data.response

data class ItemResponse(
    val id: Long,
    val price: Int,
    val amount: Int,
    val name: String,
    val imageUrl: String?
)
