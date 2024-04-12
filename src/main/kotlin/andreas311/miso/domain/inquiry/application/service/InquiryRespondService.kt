package andreas311.miso.domain.inquiry.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.auth.application.port.output.UserSecurityPort
import andreas311.miso.domain.inquiry.application.exception.InquiryNotFoundException
import andreas311.miso.domain.inquiry.application.port.input.InquiryRespondUseCase
import andreas311.miso.domain.inquiry.application.port.input.dto.WriteInquiryRespondDto
import andreas311.miso.domain.inquiry.application.port.output.CommandInquiryPort
import andreas311.miso.domain.inquiry.application.port.output.QueryInquiryPort
import andreas311.miso.domain.inquiry.domain.InquiryStatus
import andreas311.miso.domain.notification.application.port.input.InquiryNotificationSendUseCase
import andreas311.miso.domain.notification.application.port.output.CommandNotificationPort
import andreas311.miso.domain.notification.application.port.output.QueryDeviceTokenPort
import andreas311.miso.domain.notification.domain.Notification

@RollbackService
class InquiryRespondService(
    private val userSecurityPort: UserSecurityPort,
    private val queryInquiryPort: QueryInquiryPort,
    private val commandInquiryPort: CommandInquiryPort,
    private val queryDeviceTokenPort: QueryDeviceTokenPort,
    private val commandNotificationPort: CommandNotificationPort,
    private val inquiryNotificationSendUseCase: InquiryNotificationSendUseCase
) : InquiryRespondUseCase {
    override fun execute(id: Long, writeInquiryRespondDto: WriteInquiryRespondDto) {
        val user = userSecurityPort.currentUser()

        val inquiry = queryInquiryPort.findByIdOrNull(id)
            ?: throw InquiryNotFoundException()

        val deviceToken = queryDeviceTokenPort.findByUserIdOrNull(user.id)

        commandInquiryPort.saveInquiry(inquiry.updateInquiryStatus(InquiryStatus.COMPLETE))

        commandNotificationPort.saveNotification(
            Notification(
                id = 0L,
                answer = writeInquiryRespondDto.answer,
                user = user,
                inquiry = inquiry
            )
        )

        deviceToken?.let { inquiryNotificationSendUseCase.execute(inquiry, deviceToken.deviceToken) }
    }
}