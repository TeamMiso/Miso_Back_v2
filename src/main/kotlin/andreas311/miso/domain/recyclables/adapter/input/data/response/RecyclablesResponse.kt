package andreas311.miso.domain.recyclables.adapter.input.data.response

import andreas311.miso.domain.recyclables.domain.RecyclablesType

data class RecyclablesResponse(
    val title: String,
    val imageUrl: String?,
    val recycleMethod: String,
    val recyclablesType: RecyclablesType
)
