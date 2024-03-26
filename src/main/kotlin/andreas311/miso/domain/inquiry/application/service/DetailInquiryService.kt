package andreas311.miso.domain.inquiry.application.service

import andreas311.miso.common.annotation.ReadOnlyRollbackService
import andreas311.miso.domain.inquiry.application.exception.InquiryNotFoundException
import andreas311.miso.domain.inquiry.application.port.input.DetailInquiryUseCase
import andreas311.miso.domain.inquiry.application.port.input.dto.DetailInquiryDto
import andreas311.miso.domain.inquiry.application.port.output.QueryInquiryPort

@ReadOnlyRollbackService
class DetailInquiryService(
    private val queryInquiryPort: QueryInquiryPort
) : DetailInquiryUseCase {
    override fun execute(id: Long): DetailInquiryDto {
        val inquiry = queryInquiryPort.findByIdOrNull(id)
            ?: throw InquiryNotFoundException()

        return DetailInquiryDto(inquiry)
    }
}