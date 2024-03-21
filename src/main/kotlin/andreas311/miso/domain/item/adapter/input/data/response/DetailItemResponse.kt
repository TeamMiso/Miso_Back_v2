package andreas311.miso.domain.item.adapter.input.data.response

data class DetailItemResponse(
    val id: Long,
    val price: Int,
    val amount: Int,
    val name: String,
    val content: String,
    val imageUrl: String?
)
