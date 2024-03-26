package andreas311.miso.domain.inquiry.application.port.input.dto

import andreas311.miso.domain.inquiry.domain.Inquiry
import andreas311.miso.domain.inquiry.domain.InquiryStatus
import java.time.LocalDateTime

data class DetailInquiryDto(
    val id: Long,
    val inquiryDate: LocalDateTime,
    val title: String,
    val content: String,
    val imageUrl: String?,
    val inquiryStatus: InquiryStatus
) {
    constructor(inquiry: Inquiry) : this(
        id = inquiry.id,
        inquiryDate = inquiry.createdDate,
        title = inquiry.title,
        content = inquiry.content,
        imageUrl = inquiry.imageUrl,
        inquiryStatus = inquiry.inquiryStatus
    )
}
