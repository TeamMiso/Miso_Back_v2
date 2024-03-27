package andreas311.miso.domain.notification.adapter.output.persistence.entity

import andreas311.miso.domain.inquiry.adapter.output.persistence.entity.InquiryEntity
import andreas311.miso.domain.user.adapter.output.persistence.entity.UserEntity
import javax.persistence.*

@Entity
@Table(name = "notification")
data class NotificationEntity(
    @Id
    @Column(name = "notification_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "answer", nullable = false)
    val answer: String,

    @ManyToOne
    @JoinColumn(name = "inquiry_id")
    val inquiry: InquiryEntity,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity
)
