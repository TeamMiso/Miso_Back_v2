package andreas311.miso.domain.inquiry.application.service

import andreas311.miso.common.annotation.ReadOnlyRollbackService
import andreas311.miso.domain.auth.application.port.output.UserSecurityPort
import andreas311.miso.domain.inquiry.application.port.input.ListInquiryUseCase
import andreas311.miso.domain.inquiry.application.port.input.dto.InquiryDto
import andreas311.miso.domain.inquiry.application.port.input.dto.ListInquiryDto
import andreas311.miso.domain.inquiry.application.port.output.QueryInquiryPort
import andreas311.miso.domain.user.domain.Role

@ReadOnlyRollbackService
class ListInquiryService(
    private val queryInquiryPort: QueryInquiryPort,
    private val userSecurityPort: UserSecurityPort
) : ListInquiryUseCase {
    override fun execute(): ListInquiryDto {
        val user = userSecurityPort.currentUser()

        return ListInquiryDto(
            inquiryList =
            when (user.role) {
                Role.ROLE_USER -> queryInquiryPort.findAllByUser(user)
                else -> queryInquiryPort.findAll()
            }
                .map { InquiryDto(it) }
        )
    }
}
