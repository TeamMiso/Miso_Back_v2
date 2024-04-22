package andreas311.miso.domain.item.application.port.input.dto

data class CreateItemDto(
    val price: Int,
    var amount: Int,
    val name: String,
    val content: String
)
