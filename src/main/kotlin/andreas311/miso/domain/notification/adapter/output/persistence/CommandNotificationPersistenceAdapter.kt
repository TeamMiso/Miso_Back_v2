package andreas311.miso.domain.notification.adapter.output.persistence

import andreas311.miso.domain.notification.adapter.output.persistence.mapper.NotificationMapper
import andreas311.miso.domain.notification.adapter.output.persistence.repository.NotificationRepository
import andreas311.miso.domain.notification.application.port.output.CommandNotificationPort
import andreas311.miso.domain.notification.domain.Notification
import org.springframework.stereotype.Component

@Component
class CommandNotificationPersistenceAdapter(
    private val notificationMapper: NotificationMapper,
    private val notificationRepository: NotificationRepository
) : CommandNotificationPort {
    override fun saveNotification(notification: Notification): Notification {
        val notificationEntity = notificationRepository.save(notificationMapper toEntity notification)
        return notificationMapper.toDomain(notificationEntity)!!
    }
}