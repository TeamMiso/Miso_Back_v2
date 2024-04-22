package andreas311.miso.domain.notification.adapter.input.mapper

import andreas311.miso.domain.notification.adapter.input.data.DetailNotificationResponse
import andreas311.miso.domain.notification.application.port.input.dto.DetailNotificationDto
import org.springframework.stereotype.Component

@Component
class NotificationDataMapper {
    fun toResponse(detailNotificationDto: DetailNotificationDto): DetailNotificationResponse =
        DetailNotificationResponse(
            answer = detailNotificationDto.answer
        )
}