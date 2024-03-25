package andreas311.miso.domain.inquiry.adapter.output.persistence.entity

import andreas311.miso.domain.inquiry.domain.InquiryStatus
import andreas311.miso.domain.user.adapter.output.persistence.entity.UserEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "inquiry")
data class InquiryEntity(
    @Id
    @Column(name = "inquiry_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "title", length = 100, nullable = false)
    val title: String,

    @Column(name = "content", length = 500, nullable = false)
    val content: String,

    @Column(name = "imageUrl", nullable = true)
    val imageUrl: String?,

    @Enumerated(EnumType.STRING)
    @Column(name = "inquiryStatus")
    var inquiryStatus: InquiryStatus,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity,

    @Column(name = "created_date", updatable = false)
    val createdDate: LocalDateTime
)
