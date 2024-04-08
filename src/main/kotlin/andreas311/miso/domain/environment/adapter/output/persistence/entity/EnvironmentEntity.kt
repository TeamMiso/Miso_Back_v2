package andreas311.miso.domain.environment.adapter.output.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "environment")
data class EnvironmentEntity(
    @Id
    @Column(name = "environment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "title", nullable = false)
    val title: String,

    @Column(name = "content", nullable = false, length = 10000)
    val content: String,

    @Column(name = "imageUrl", nullable = true)
    val imageUrl: String?,
)