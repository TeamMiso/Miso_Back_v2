package andreas311.miso.domain.environment.domain

data class Environment(
    val id: Long,
    val title: String,
    val content: String,
    val imageUrl: String?,
)
