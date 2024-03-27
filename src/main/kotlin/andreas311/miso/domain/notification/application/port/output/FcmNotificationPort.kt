package andreas311.miso.domain.notification.application.port.output

import andreas311.miso.domain.notification.domain.NotificationAlarm

interface FcmNotificationPort {
    fun sendInquiryNotification(deviceToken: String, notificationAlarm: NotificationAlarm)
    fun sendEnvironmentNotification(deviceTokens: List<String>, notificationAlarm: NotificationAlarm)
}