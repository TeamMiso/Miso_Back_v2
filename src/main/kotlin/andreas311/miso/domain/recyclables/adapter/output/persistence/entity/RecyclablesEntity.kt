package andreas311.miso.domain.recyclables.adapter.output.persistence.entity

import andreas311.miso.domain.recyclables.domain.RecyclablesType
import javax.persistence.*

@Entity
@Table(name = "recyclables")
data class RecyclablesEntity(
    @Id
    @Column(name = "recyclables_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "title", nullable = false)
    val title: String,

    @Column(name = "sub_title", nullable = false)
    val subTitle: String,

    @Column(name = "recycle_method", nullable = false, length = 5000)
    val recycleMethod: String,

    @Column(name = "recycle_tip", nullable = false, length = 5000)
    val recycleTip: String,

    @Column(name = "recycle_caution", nullable = false, length = 5000)
    val recycleCaution: String,

    @Column(name = "imageUrl", nullable = true)
    val imageUrl: String?,

    @Enumerated(EnumType.STRING)
    @Column(name = "recyclables_type", nullable = false)
    val recyclablesType: RecyclablesType,

    @Column(name = "recycle_mark", nullable = false)
    val recycleMark: String
)
