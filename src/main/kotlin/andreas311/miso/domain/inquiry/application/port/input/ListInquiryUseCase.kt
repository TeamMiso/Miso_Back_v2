package andreas311.miso.domain.inquiry.application.port.input

import andreas311.miso.domain.inquiry.application.port.input.dto.ListInquiryDto

interface ListInquiryUseCase {
    fun execute(): ListInquiryDto
}