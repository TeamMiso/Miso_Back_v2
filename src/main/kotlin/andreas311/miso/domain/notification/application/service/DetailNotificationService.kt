package andreas311.miso.domain.notification.application.service

import andreas311.miso.common.annotation.ReadOnlyRollbackService
import andreas311.miso.domain.notification.application.exception.NotificationNotFoundException
import andreas311.miso.domain.notification.application.port.input.DetailNotificationUseCase
import andreas311.miso.domain.notification.application.port.input.dto.DetailNotificationDto
import andreas311.miso.domain.notification.application.port.output.QueryNotificationPort
import org.springframework.cache.annotation.Cacheable

@ReadOnlyRollbackService
class DetailNotificationService(
    private val queryNotificationPort: QueryNotificationPort
) : DetailNotificationUseCase {
    @Cacheable(cacheNames = ["inquiryRespond"], key = "#id", cacheManager = "redisCacheManager")
    override fun execute(id: Long): DetailNotificationDto {
        val notification = queryNotificationPort.findByInquiryIdOrNull(id)
            ?: throw NotificationNotFoundException()

        return DetailNotificationDto(notification)
    }
}