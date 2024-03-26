package andreas311.miso.domain.inquiry.application.service

import andreas311.miso.common.annotation.ReadOnlyRollbackService
import andreas311.miso.domain.auth.application.port.output.UserSecurityPort
import andreas311.miso.domain.inquiry.application.port.input.ListFilterInquiryUseCase
import andreas311.miso.domain.inquiry.application.port.input.dto.InquiryDto
import andreas311.miso.domain.inquiry.application.port.input.dto.ListInquiryDto
import andreas311.miso.domain.inquiry.application.port.output.QueryInquiryPort
import andreas311.miso.domain.inquiry.domain.InquiryStatus
import andreas311.miso.domain.user.domain.Role

@ReadOnlyRollbackService
class ListFilterInquiryService(
    private val queryInquiryPort: QueryInquiryPort,
    private val userSecurityPort: UserSecurityPort
) : ListFilterInquiryUseCase {
    override fun execute(inquiryStatus: InquiryStatus): ListInquiryDto {
        val user = userSecurityPort.currentUser()

        return ListInquiryDto(
            inquiryList =
            when (user.role) {
                Role.ROLE_USER -> queryInquiryPort.findAllByUserAndInquiryStatus(user, inquiryStatus)
                else -> queryInquiryPort.findAllByInquiryStatus(inquiryStatus)
            }
                .map { InquiryDto(it) }
        )
    }
}