package andreas311.miso.domain.recyclables.application.port.input.dto

import andreas311.miso.domain.recyclables.domain.Recyclables
import andreas311.miso.domain.recyclables.domain.RecyclablesType

data class DetailRecyclablesDto(
    val id: Long,
    val title: String,
    val subTitle: String,
    val recycleMethod: String,
    val recycleTip: String,
    val recycleCaution: String,
    val imageUrl: String?,
    val recyclablesType: RecyclablesType,
    val recycleMark: String
) {
    constructor(recyclables: Recyclables) : this(
        id = recyclables.id,
        title = recyclables.title,
        subTitle = recyclables.subTitle,
        recycleMethod = recyclables.recycleMethod,
        recycleTip = recyclables.recycleTip,
        recycleCaution = recyclables.recycleCaution,
        imageUrl = recyclables.imageUrl,
        recyclablesType = recyclables.recyclablesType,
        recycleMark = recyclables.recycleMark
    )

    constructor() : this(
        id = 0L,
        title = "",
        subTitle = "",
        recycleMethod = "",
        recycleTip = "",
        recycleCaution = "",
        imageUrl = null,
        recyclablesType = RecyclablesType.BAG,
        recycleMark = ""
    )
}
