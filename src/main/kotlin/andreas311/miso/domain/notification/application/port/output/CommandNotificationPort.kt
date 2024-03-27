package andreas311.miso.domain.notification.application.port.output

import andreas311.miso.domain.notification.domain.Notification

interface CommandNotificationPort {
    fun saveNotification(notification: Notification): Notification
}