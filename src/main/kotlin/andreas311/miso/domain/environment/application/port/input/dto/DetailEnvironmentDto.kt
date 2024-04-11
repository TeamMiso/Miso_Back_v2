package andreas311.miso.domain.environment.application.port.input.dto

import andreas311.miso.domain.environment.domain.TodayEnvironment

data class DetailEnvironmentDto(
    val title: String,
    val content: String,
    val imageUrl: String?
) {
    constructor(todayEnvironment: TodayEnvironment): this(
        title = todayEnvironment.title,
        content = todayEnvironment.content,
        imageUrl = todayEnvironment.imageUrl
    )
}
