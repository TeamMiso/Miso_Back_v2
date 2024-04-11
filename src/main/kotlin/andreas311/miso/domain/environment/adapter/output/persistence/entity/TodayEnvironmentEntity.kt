package andreas311.miso.domain.environment.adapter.output.persistence.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "today_environment")
data class TodayEnvironmentEntity(
    @Id
    @Column(name = "today_environment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "content", nullable = true, length = 5000)
    var content: String,

    @Column(name = "imageUrl", nullable = true)
    var imageUrl: String?,
)
