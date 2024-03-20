package andreas311.miso.domain.item.application.port.input.dto

data class EditItemDto(
    val price: Int,
    var amount: Int,
    val name: String,
    val content: String
)
