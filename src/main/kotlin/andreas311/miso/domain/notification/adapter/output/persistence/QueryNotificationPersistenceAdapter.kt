package andreas311.miso.domain.notification.adapter.output.persistence

import andreas311.miso.domain.notification.adapter.output.persistence.mapper.NotificationMapper
import andreas311.miso.domain.notification.adapter.output.persistence.repository.NotificationRepository
import andreas311.miso.domain.notification.application.port.output.QueryNotificationPort
import andreas311.miso.domain.notification.domain.Notification
import org.springframework.stereotype.Component

@Component
class QueryNotificationPersistenceAdapter(
    private val notificationMapper: NotificationMapper,
    private val notificationRepository: NotificationRepository
) : QueryNotificationPort {
    override fun findByInquiryIdOrNull(id: Long): Notification? {
        val notificationEntity = notificationRepository.findByInquiryId(id)
        return notificationMapper toDomain notificationEntity
    }
}