package andreas311.miso.domain.inquiry.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.auth.application.port.output.UserSecurityPort
import andreas311.miso.domain.inquiry.application.exception.InquiryNotFoundException
import andreas311.miso.domain.inquiry.application.port.input.WriteInquiryRespondUseCase
import andreas311.miso.domain.inquiry.application.port.input.dto.WriteInquiryRespondDto
import andreas311.miso.domain.inquiry.application.port.output.CommandInquiryPort
import andreas311.miso.domain.inquiry.application.port.output.QueryInquiryPort
import andreas311.miso.domain.inquiry.domain.InquiryStatus
import andreas311.miso.domain.notification.application.port.output.CommandNotificationPort
import andreas311.miso.domain.notification.domain.Notification

@RollbackService
class WriteInquiryRespondService(
    private val userSecurityPort: UserSecurityPort,
    private val queryInquiryPort: QueryInquiryPort,
    private val commandInquiryPort: CommandInquiryPort,
    private val commandNotificationPort: CommandNotificationPort
) : WriteInquiryRespondUseCase {
    override fun execute(id: Long, writeInquiryRespondDto: WriteInquiryRespondDto) {
        val user = userSecurityPort.currentUser()

        val inquiry = queryInquiryPort.findByIdOrNull(id)
            ?: throw InquiryNotFoundException()

        commandInquiryPort.saveInquiry(inquiry.updateInquiryStatus(InquiryStatus.COMPLETE))

        commandNotificationPort.saveNotification(
            Notification(
                id = 0L,
                answer = writeInquiryRespondDto.answer,
                user = user,
                inquiry = inquiry
            )
        )
    }
}