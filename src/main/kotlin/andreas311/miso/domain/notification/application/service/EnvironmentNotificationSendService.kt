package andreas311.miso.domain.notification.application.service

import andreas311.miso.domain.notification.application.port.input.EnvironmentNotificationSendUseCase
import andreas311.miso.domain.notification.application.port.output.FcmNotificationPort
import andreas311.miso.domain.notification.application.port.output.QueryDeviceTokenPort
import andreas311.miso.domain.notification.domain.NotificationAlarm
import andreas311.miso.domain.notification.domain.NotificationType
import org.springframework.stereotype.Component

@Component
class EnvironmentNotificationSendService(
    private val fcmNotificationPort: FcmNotificationPort,
    private val queryDeviceTokenPort: QueryDeviceTokenPort
) : EnvironmentNotificationSendUseCase {
    override fun execute() {

        runCatching {
            fcmNotificationPort.sendEnvironmentNotification(
                deviceTokens = queryDeviceTokenPort.findAll().map { it.deviceToken },
                notificationAlarm = NotificationAlarm(
                    title = NotificationType.ENVIRONMENT.title,
                    content = NotificationType.ENVIRONMENT.content,
                    writer = "미소"
                )
            )

        }.onFailure {
            it.printStackTrace()
        }
    }
}