package andreas311.miso.domain.recyclables.application.port.input.dto

import andreas311.miso.domain.recyclables.domain.Recyclables
import andreas311.miso.domain.recyclables.domain.RecyclablesType

data class RecyclablesDto(
    val title: String,
    val imageUrl: String?,
    val recycleMethod: String,
    val recyclablesType: RecyclablesType
) {
    constructor(recyclables: Recyclables) : this(
        title = recyclables.title,
        imageUrl = recyclables.imageUrl,
        recycleMethod = recyclables.recycleMethod,
        recyclablesType = recyclables.recyclablesType
    )
}
