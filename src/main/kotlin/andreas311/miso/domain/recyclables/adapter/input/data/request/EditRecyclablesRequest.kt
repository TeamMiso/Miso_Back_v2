package andreas311.miso.domain.recyclables.adapter.input.data.request

import andreas311.miso.domain.recyclables.domain.RecyclablesType
import javax.validation.constraints.NotNull

data class EditRecyclablesRequest(
    @field:NotNull
    val title: String,
    @field:NotNull
    val subTitle: String,
    @field:NotNull
    val recycleMethod: String,
    @field:NotNull
    val recycleTip: String,
    @field:NotNull
    val recycleCaution: String,
    @field:NotNull
    val recyclablesType: RecyclablesType,
    @field:NotNull
    val recycleMark: String
)
