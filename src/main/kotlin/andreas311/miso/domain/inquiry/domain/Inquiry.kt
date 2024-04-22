package andreas311.miso.domain.inquiry.domain

import andreas311.miso.domain.user.domain.User
import java.time.LocalDateTime

data class Inquiry(
    val id: Long,
    val title: String,
    val content: String,
    val imageUrl: String?,
    var inquiryStatus: InquiryStatus,
    val user: User,
    val createdDate: LocalDateTime
) {
    fun updateInquiryStatus(inquiryStatus: InquiryStatus): Inquiry {
        this.inquiryStatus = inquiryStatus
        return this
    }
}