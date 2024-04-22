package andreas311.miso.domain.recyclables.application.port.input.dto

import andreas311.miso.domain.recyclables.domain.RecyclablesType

data class CreateRecyclablesDto(
    val title: String,
    val subTitle: String,
    val recycleMethod: String,
    val recycleTip: String,
    val recycleCaution: String,
    val recyclablesType: RecyclablesType,
    val recycleMark: String
)
