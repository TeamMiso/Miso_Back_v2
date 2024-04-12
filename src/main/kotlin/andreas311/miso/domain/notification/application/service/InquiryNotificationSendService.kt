package andreas311.miso.domain.notification.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.inquiry.domain.Inquiry
import andreas311.miso.domain.inquiry.domain.InquiryStatus
import andreas311.miso.domain.notification.application.port.input.InquiryNotificationSendUseCase
import andreas311.miso.domain.notification.application.port.output.FcmNotificationPort
import andreas311.miso.domain.notification.domain.NotificationAlarm
import andreas311.miso.domain.notification.domain.NotificationType

@RollbackService
class InquiryNotificationSendService(
    private val fcmNotificationPort: FcmNotificationPort
) : InquiryNotificationSendUseCase {
    override fun execute(inquiry: Inquiry, token: String) {
        val notificationType = when (inquiry.inquiryStatus) {
            InquiryStatus.WAIT -> NotificationType.INQUIRY_WAIT
            InquiryStatus.COMPLETE -> NotificationType.INQUIRY_COMPLETE
        }

        runCatching {
            fcmNotificationPort.sendInquiryNotification(
                deviceToken = token,
                notificationAlarm = NotificationAlarm(
                    title = notificationType.title,
                    content = notificationType.content,
                    writer = "미소"
                )
            )

        }.onFailure {
            it.printStackTrace()
        }
    }
}