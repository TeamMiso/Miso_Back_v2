package andreas311.miso.domain.notification.domain

import andreas311.miso.domain.inquiry.domain.Inquiry
import andreas311.miso.domain.user.domain.User

data class Notification(
    val id: Long,
    val answer: String,
    val inquiry: Inquiry,
    val user: User
)
