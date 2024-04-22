package andreas311.miso.domain.inquiry.adapter.input.data.response

import andreas311.miso.domain.inquiry.domain.InquiryStatus
import java.time.LocalDateTime

data class DetailInquiryResponse(
    val id: Long,
    val inquiryDate: LocalDateTime,
    val title: String,
    val content: String,
    val imageUrl: String?,
    val inquiryStatus: InquiryStatus
)
