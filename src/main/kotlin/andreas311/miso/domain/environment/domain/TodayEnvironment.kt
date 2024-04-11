package andreas311.miso.domain.environment.domain

data class TodayEnvironment(
    val id: Long,
    var title: String,
    var content: String,
    var imageUrl: String?,
)
