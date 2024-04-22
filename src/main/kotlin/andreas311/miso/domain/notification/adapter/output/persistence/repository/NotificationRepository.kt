package andreas311.miso.domain.notification.adapter.output.persistence.repository

import andreas311.miso.domain.notification.adapter.output.persistence.entity.NotificationEntity
import org.springframework.data.repository.CrudRepository

interface NotificationRepository : CrudRepository<NotificationEntity, Long> {
    fun findByInquiryId(id: Long): NotificationEntity?
}