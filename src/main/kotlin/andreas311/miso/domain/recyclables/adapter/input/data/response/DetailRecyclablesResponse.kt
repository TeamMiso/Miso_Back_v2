package andreas311.miso.domain.recyclables.adapter.input.data.response

import andreas311.miso.domain.recyclables.domain.RecyclablesType

data class DetailRecyclablesResponse(
    val id: Long,
    val title: String,
    val subTitle: String,
    val recycleMethod: String,
    val recycleTip: String,
    val recycleCaution: String,
    val imageUrl: String?,
    val recyclablesType: RecyclablesType,
    val recycleMark: String
)
