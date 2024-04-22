package andreas311.miso.domain.environment.domain

data class TodayEnvironment(
    val id: Long,
    var title: String,
    var content: String,
    var imageUrl: String?,
) {
    fun updateTodayEnvironment(environment: Environment): TodayEnvironment {
        title = environment.title
        content = environment.content
        imageUrl = environment.imageUrl
        return this
    }
}
