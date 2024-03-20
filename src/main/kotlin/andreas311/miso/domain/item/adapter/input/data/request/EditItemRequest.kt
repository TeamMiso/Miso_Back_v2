package andreas311.miso.domain.item.adapter.input.data.request

import javax.validation.constraints.NotNull

data class EditItemRequest(
    @field:NotNull
    val price: Int,
    @field:NotNull
    var amount: Int,
    @field:NotNull
    val name: String,
    @field:NotNull
    val content: String
)
