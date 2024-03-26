package andreas311.miso.domain.inquiry.application.port.input

import andreas311.miso.domain.inquiry.application.port.input.dto.ListInquiryDto
import andreas311.miso.domain.inquiry.domain.InquiryStatus

interface ListFilterInquiryUseCase {
    fun execute(inquiryStatus: InquiryStatus): ListInquiryDto
}