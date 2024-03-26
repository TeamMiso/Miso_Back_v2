package andreas311.miso.domain.inquiry.application.port.input

import andreas311.miso.domain.inquiry.application.port.input.dto.DetailInquiryDto

interface DetailInquiryUseCase {
    fun execute(id: Long): DetailInquiryDto
}