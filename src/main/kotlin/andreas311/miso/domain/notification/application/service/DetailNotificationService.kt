package andreas311.miso.domain.notification.application.service

import andreas311.miso.common.annotation.ReadOnlyRollbackService
import andreas311.miso.domain.notification.application.exception.NotificationNotFoundException
import andreas311.miso.domain.notification.application.port.input.DetailNotificationUseCase
import andreas311.miso.domain.notification.application.port.input.dto.DetailNotificationDto
import andreas311.miso.domain.notification.application.port.output.QueryNotificationPort

@ReadOnlyRollbackService
class DetailNotificationService(
    private val queryNotificationPort: QueryNotificationPort
) : DetailNotificationUseCase {
    override fun execute(id: Long): DetailNotificationDto {
        val notification = queryNotificationPort.findByInquiryIdOrNull(id)
            ?: throw NotificationNotFoundException()

        return DetailNotificationDto(notification)
    }
}